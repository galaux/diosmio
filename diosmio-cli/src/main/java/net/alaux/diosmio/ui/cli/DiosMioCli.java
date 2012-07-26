package net.alaux.diosmio.ui.cli;

import net.alaux.diosmio.ui.cli.core.CliArtifactManagerJmxActions;
import net.alaux.diosmio.ui.cli.core.CliMiscJmxActions;
import net.alaux.diosmio.ui.cli.core.KissLogger;
import org.apache.commons.cli.*;


import javax.management.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;


public class DiosMioCli {

    private static Options options;
    private static DiosMioCli diosmioCli;



    private static final String DM_CLI_VERSION = "1.0-SNAPSHOT";

    // Technical options
    private static final String OPT_TECH_HELP = "h";
    private static final String OPT_TECH_HELP_L = "help";

    private static final String OPT_TECH_LOG_WARN = "v";
    private static final String OPT_TECH_LOG_INFO = "vv";
    private static final String OPT_TECH_LOG_DEBUG = "vvv";

    public static final String OPT_TECH_CONFIG_FILE_L = "config-file";
    public static final String OPT_TECH_CONFIG_FILE = "c";

    // Misc options
    private static final String OPT_MISC_SHOW_BEANS = "s";
    private static final String OPT_MISC_SHOW_BEANS_L = "show-beans";

    // Artifact Manager options
    private static final String OPT_ARTIF_MNGR_ADD = "a";
    private static final String OPT_ARTIF_MNGR_ADD_L = "add-artifact";

    private static final String OPT_ARTIF_MNGR_LIST = "l";
    private static final String OPT_ARTIF_MNGR_LIST_L = "list-artifacts";

    private static final String OPT_ARTIF_MNGR_DEL = "d";
    private static final String OPT_ARTIF_MNGR_DEL_L = "delete-artifact";

    private static KissLogger logger;

    private static final String DIOSMIOCLI_LOG_PATH = "/tmp/diosmio-cli.log";

    private static final String DEFAULT_CONF_PATH = "diosmio-cli.conf";
    private static String configFilePath;
    private static Properties properties;


    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     *
     * @param filePath
     * @param defaultFilePath
     * @return
     * @throws IOException
     * @throws Exception
     */
    public Properties getDiosMioProperties(String filePath, String defaultFilePath) throws IOException, Exception {

        logger.info("Trying to load property file");

        InputStream is = null;
        if (filePath != null) {
            File f = new File(filePath);
            if (f.exists() && f.canRead()) {
                is = new FileInputStream(f);
            } else {
                logger.error("Cannot access specified configuration file (" + filePath + ")");
            }
        }

        if (is == null) {
            logger.info("Falling back to default configuration file (" + defaultFilePath + ")");
            is = ClassLoader.getSystemClassLoader().getResourceAsStream(defaultFilePath);
        }

        if (is == null) {
            // TODO Handle this properly
            throw new Exception("cli.no_config_file");
        }

        Properties res =  new Properties();
        res.load(is);
        return res;
    }

    /**
     *
     * @throws IOException
     * @throws MalformedObjectNameException
     * @throws InstanceNotFoundException
     */
    public DiosMioCli(String[] args) {

        try {
            // Parse command line
            options = new Options();

            // Technical options
            options.addOption(OPT_TECH_HELP, OPT_TECH_HELP_L, false, "give this help");

            options.addOption(OPT_TECH_LOG_WARN, false, "display 'warning' logs");
            options.addOption(OPT_TECH_LOG_INFO, false, "display 'info' logs");
            options.addOption(OPT_TECH_LOG_DEBUG, false, "display 'debug' logs");

            options.addOption(OptionBuilder.withLongOpt(OPT_TECH_CONFIG_FILE_L)
                    .hasArg()
                    .withArgName("file")
                    .withDescription("use alternate config file")
                    .create(OPT_TECH_CONFIG_FILE));

            // Misc
            options.addOption(OPT_MISC_SHOW_BEANS, OPT_MISC_SHOW_BEANS_L, false, "list available beans");

            // Artifact Manager
            options.addOption(OptionBuilder.withLongOpt(OPT_ARTIF_MNGR_ADD_L)
                    .hasArg()
                    .withArgName("artifact")
                    .withDescription("add artifact to database")
                    .create(OPT_ARTIF_MNGR_ADD));
            options.addOption(OptionBuilder.withLongOpt(OPT_ARTIF_MNGR_LIST_L)
                    .withDescription("list artifacts in database")
                    .create(OPT_ARTIF_MNGR_LIST));
            options.addOption(OptionBuilder.withLongOpt(OPT_ARTIF_MNGR_DEL_L)
                    .hasArg()
                    .withArgName("artifactId")
                    .withDescription("delete artifact from database")
                    .create(OPT_ARTIF_MNGR_DEL));

            CommandLineParser parser = new PosixParser();
            CommandLine cmd = parser.parse( options, args);

            // TODO Make some command line basic verification (ie "One OPT at least", "Only one OPT")

            // First process log level stuff
            if (cmd.hasOption(OPT_TECH_LOG_WARN)) {
                logger = new KissLogger(KissLogger.Level.WARNING, DIOSMIOCLI_LOG_PATH);
            } else if (cmd.hasOption(OPT_TECH_LOG_INFO)) {
                logger = new KissLogger(KissLogger.Level.INFO, DIOSMIOCLI_LOG_PATH);
            } else if (cmd.hasOption(OPT_TECH_LOG_DEBUG)) {
                logger = new KissLogger(KissLogger.Level.DEBUG, DIOSMIOCLI_LOG_PATH);
            } else {
                logger = new KissLogger(KissLogger.Level.SHUT_UP, DIOSMIOCLI_LOG_PATH);
            }

            logger.info("Parsing options");

            // Other technical options ************************
            properties = getDiosMioProperties(cmd.getOptionValue(OPT_TECH_CONFIG_FILE), DEFAULT_CONF_PATH);

            // Misc *******************************************
            if (cmd.hasOption(OPT_TECH_HELP)) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("diosmio-cli <option> [...]", options);
            } else if (cmd.hasOption(OPT_MISC_SHOW_BEANS)) {
                logger.info("Option '" + OPT_MISC_SHOW_BEANS_L + "' found");
                CliMiscJmxActions cliMiscJmxActions = new CliMiscJmxActions();
                cliMiscJmxActions.displayMBeanList();
                cliMiscJmxActions.closeJmxConnection();

                // Artifact Manager ***************************
            } else if (cmd.hasOption(OPT_ARTIF_MNGR_LIST)) {
                logger.info("Option '" + OPT_ARTIF_MNGR_LIST_L+ "' found");
                CliArtifactManagerJmxActions cliArtifactManagerJmxActions = new CliArtifactManagerJmxActions();
                cliArtifactManagerJmxActions.listArtifacts();
                cliArtifactManagerJmxActions.closeJmxConnection();
            } else if (cmd.hasOption(OPT_ARTIF_MNGR_ADD)) {
                logger.info("Option '" + OPT_ARTIF_MNGR_ADD_L + "' found with value '" + cmd.getOptionValue(OPT_ARTIF_MNGR_ADD) + "'");
                CliArtifactManagerJmxActions cliArtifactManagerJmxActions = new CliArtifactManagerJmxActions();
                cliArtifactManagerJmxActions.addArtifact(cmd.getOptionValue(OPT_ARTIF_MNGR_ADD));
                cliArtifactManagerJmxActions.closeJmxConnection();
            } else if (cmd.hasOption(OPT_ARTIF_MNGR_DEL)) {
                logger.info("Option '" + OPT_ARTIF_MNGR_DEL_L + "' found with value '" + cmd.getOptionValue(OPT_ARTIF_MNGR_DEL) + "'");
                CliArtifactManagerJmxActions cliArtifactManagerJmxActions = new CliArtifactManagerJmxActions();
                cliArtifactManagerJmxActions.deleteArtifact(cmd.getOptionValue(OPT_ARTIF_MNGR_DEL));
                cliArtifactManagerJmxActions.closeJmxConnection();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            logger.error(e.getMessage());
        } finally {
            logger.info("I'm done!");
            logger.info("----------------------");
            logger.close();
        }
    }

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) {
        diosmioCli = new DiosMioCli(args);
    }
}

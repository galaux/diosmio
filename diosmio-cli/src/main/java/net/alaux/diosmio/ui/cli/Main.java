package net.alaux.diosmio.ui.cli;

import net.alaux.diosmio.ui.cli.jmxcli.DiosMioJmxCli;
import net.alaux.diosmio.ui.cli.net.alaux.logging.KissLogger;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 8/4/12
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    private static final String DM_CLI_VERSION = "1.0-SNAPSHOT";

    // Technical opt
    private static final String OPT_TECH_HELP = "h";
    private static final String OPT_TECH_HELP_L = "help";

    private static final String OPT_TECH_LOG_WARN = "v";
    private static final String OPT_TECH_LOG_INFO = "vv";
    private static final String OPT_TECH_LOG_DEBUG = "vvv";

    public static final String OPT_TECH_CONFIG_FILE_L = "conf";
    public static final String OPT_TECH_CONFIG_FILE = "c";

    // Misc opt
//    private static final String OPT_MISC_SHOW_BEANS = "s";
    private static final String OPT_MISC_LIST_BEANS_L = "lsbeans";

    //    private static final String OPT_MISC_STATUS = "???";
    private static final String OPT_MISC_SHOW_STATUS_L = "status";

    // Artifact Manager opt
//    private static final String OPT_ARTIF_MNGR_ADD = "a";
    private static final String OPT_ARTIF_MNGR_ADD_L = "add";

    //    private static final String OPT_ARTIF_MNGR_LIST = "l";
    private static final String OPT_ARTIF_MNGR_LIST_L = "ls";

    private static final String OPT_ARTIF_MNGR_GET_L = "get";

    //    private static final String OPT_ARTIF_MNGR_DEL = "d";
    private static final String OPT_ARTIF_MNGR_DEL_L = "rm";

    // TODO Get this value from config file
    private static final String DIOSMIOCLI_LOG_PATH = "/tmp/diosmio-cli.log";


    private static final String DEFAULT_CONF_PATH = "diosmio-cli.conf";
    private static String configFilePath;

    KissLogger logger;

    /**
     *
     */
    public Main(String[] args) {

        try {
            // Parse command line
            Options options = createOptions();
            CommandLineParser parser = new PosixParser();
            CommandLine cmd = parser.parse(options, args);

            // TODO Make some command line basic verification (ie "One OPT at least", "Only one OPT")

            logger = getLogger(cmd);

            // Other technical opt ************************
            Properties properties = getDiosMioProperties(cmd.getOptionValue(OPT_TECH_CONFIG_FILE), DEFAULT_CONF_PATH);

            DiosMioCli diosmioCli = new DiosMioJmxCli(properties.getProperty("cli.rmi.url"),
                    properties.getProperty("common.domain_name"),
                    logger);

            executeAction(diosmioCli, cmd, options, properties, logger);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            if (logger != null) {
                logger.error(e.getMessage());
            }
        } finally {
            if (logger != null) {
                logger.close();
            }
        }
    }

    /**
     *
     * @param filePath
     * @param defaultFilePath
     * @return
     * @throws java.io.IOException
     * @throws Exception
     */
    public Properties getDiosMioProperties(String filePath, String defaultFilePath) throws IOException, Exception {

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

    private Options createOptions() {

        Options opt = new Options();

        // Technical opt
        opt.addOption(OPT_TECH_HELP, OPT_TECH_HELP_L, false, "give this help");

        opt.addOption(OPT_TECH_LOG_WARN, false, "display 'warning' logs");
        opt.addOption(OPT_TECH_LOG_INFO, false, "display 'info' logs");
        opt.addOption(OPT_TECH_LOG_DEBUG, false, "display 'debug' logs");

        opt.addOption(OptionBuilder.hasArg()
                .withArgName("file")
                .withDescription("use alternate config file")
                .withLongOpt(OPT_TECH_CONFIG_FILE_L)
                .create(OPT_TECH_CONFIG_FILE));

        // Misc
        opt.addOption(OptionBuilder.withDescription("list available beans")
                .withLongOpt(OPT_MISC_LIST_BEANS_L)
                .create());
        opt.addOption(OptionBuilder.withDescription("show application status")
                .withLongOpt(OPT_MISC_SHOW_STATUS_L)
                .create());

        // Artifact Manager
        opt.addOption(OptionBuilder.hasArg()
                .withArgName("artifact")
                .withDescription("add artifact to database")
                .withLongOpt(OPT_ARTIF_MNGR_ADD_L)
                .create());

        opt.addOption(OptionBuilder.hasArg()
                .withArgName("artifactId")
                .withType(Long.class)
                .withDescription("list artifacts in database")
                .withLongOpt(OPT_ARTIF_MNGR_GET_L)
                .create());

        opt.addOption(OptionBuilder.withDescription("show an artifact")
                .withLongOpt(OPT_ARTIF_MNGR_LIST_L)
                .create());

        opt.addOption(OptionBuilder.hasArg()
                .withArgName("artifactId")
                .withType(Long.class)
                .withDescription("delete artifact from database")
                .withLongOpt(OPT_ARTIF_MNGR_DEL_L)
                .create());

        return  opt;
    }

    private KissLogger getLogger(CommandLine cmd) {

        KissLogger result = null;

        // First process log level stuff
        if (cmd.hasOption(OPT_TECH_LOG_WARN)) {
            result = new KissLogger(KissLogger.Level.WARNING, DIOSMIOCLI_LOG_PATH);
        } else if (cmd.hasOption(OPT_TECH_LOG_INFO)) {
            result = new KissLogger(KissLogger.Level.INFO, DIOSMIOCLI_LOG_PATH);
        } else if (cmd.hasOption(OPT_TECH_LOG_DEBUG)) {
            result = new KissLogger(KissLogger.Level.DEBUG, DIOSMIOCLI_LOG_PATH);
        } else {
            result = new KissLogger(KissLogger.Level.SHUT_UP, DIOSMIOCLI_LOG_PATH);
        }

        return result;
    }

    public void executeAction(DiosMioCli diosMioCli, CommandLine cmd, Options options, Properties properties, KissLogger logger) throws Exception {

        // Misc *******************************************
        if (cmd.hasOption(OPT_TECH_HELP)) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("diosmio-cli <option> [...]", options);

        } else if (cmd.hasOption(OPT_MISC_LIST_BEANS_L)) {
            logger.info("Option '" + OPT_MISC_LIST_BEANS_L + "' found");
            diosMioCli.displayMBeanList();

        } else if (cmd.hasOption(OPT_MISC_SHOW_STATUS_L)) {
            logger.info("Option '" + OPT_MISC_SHOW_STATUS_L + "' found");
            diosMioCli.displayStatus();

            // Artifact Manager ***************************
        } else if (cmd.hasOption(OPT_ARTIF_MNGR_LIST_L)) {
            logger.info("Option '" + OPT_ARTIF_MNGR_LIST_L+ "' found");
            diosMioCli.listAllArtifacts();

        } else if (cmd.hasOption(OPT_ARTIF_MNGR_GET_L)) {
            logger.info("Option '" + OPT_ARTIF_MNGR_GET_L + "' found with value '" + cmd.getOptionValue(OPT_ARTIF_MNGR_GET_L) + "'");
            diosMioCli.showArtifact(new Long(cmd.getOptionValue(OPT_ARTIF_MNGR_GET_L)));

        } else if (cmd.hasOption(OPT_ARTIF_MNGR_ADD_L)) {
            logger.info("Option '" + OPT_ARTIF_MNGR_ADD_L + "' found with value '" + cmd.getOptionValue(OPT_ARTIF_MNGR_ADD_L) + "'");
            diosMioCli.create(cmd.getOptionValue(OPT_ARTIF_MNGR_ADD_L));

        } else if (cmd.hasOption(OPT_ARTIF_MNGR_DEL_L)) {
            logger.info("Option '" + OPT_ARTIF_MNGR_DEL_L + "' found with value '" + cmd.getOptionValue(OPT_ARTIF_MNGR_DEL_L) + "'");
            diosMioCli.delete(new Long(cmd.getOptionValue(OPT_ARTIF_MNGR_DEL_L)));
        }

        diosMioCli.close();
    }

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) {

        Main main = new Main(args);
    }
}

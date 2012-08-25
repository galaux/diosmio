package net.alaux.diosmio.ui.cli;

import jline.*;
import net.alaux.diosmio.ui.cli.antlr.DiosMioCliLexer;
import net.alaux.diosmio.ui.cli.antlr.DiosMioCliParser;
import net.alaux.diosmio.ui.cli.jmx.DiosMioJmxCli;
import net.alaux.diosmio.ui.cli.net.alaux.logging.KissLogger;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.apache.commons.cli.*;

import javax.management.InstanceNotFoundException;
import java.io.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 8/4/12
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static final String APP_NAME = "DiosMio CLI";
    private static final String APP_VERSION = "1.0-SNAPSHOT";

    // Technical opt
    private static final String OPT_TECH_HELP = "h";
    private static final String OPT_TECH_HELP_L = "help";

    private static final String OPT_TECH_LOG = "v";
    private static final String OPT_TECH_LOG_L = "verbose";

    private static final String OPT_TECH_LOG_FILE = "l";
    private static final String OPT_TECH_LOG_FILE_L = "log-file";

    public static final String OPT_TECH_CONFIG_FILE = "c";
    public static final String OPT_TECH_CONFIG_FILE_L = "conf";

    // TODO Get this value from config file
    private static final String DEFAULT_LOG_PATH = "/tmp/diosmio-cli.log";


    private static final String DEFAULT_CONF_PATH = "diosmio-cli.conf";
    private static String configFilePath;

    public static final String PROMPT = "DiosMioCLI> ";

    public static final String LINE_SEP = System.getProperty("line.separator");

    private static final String usage =
            APP_NAME + " v" + APP_VERSION + LINE_SEP +
                    "\tadd [ artifact | config ] file" + LINE_SEP +
                    "\t\tadd specified element to database" + LINE_SEP +
                    "\tget [ artifact | config ] id" + LINE_SEP +
                    "\t\tretrieve specified element and display it" + LINE_SEP +
                    "\tget [ artifact | config ]" + LINE_SEP +
                    "\t\tlist all elements" + LINE_SEP +
                    "\tdelete [ artifact | config ] id" + LINE_SEP +
                    "\t\tdelete specified element";

    public static final String ELEMENT_CONFIG = "config";
    public static final String ELEMENT_ARTIFACT = "artifact";

    public static KissLogger logger;
    public static final KissLogger.Level CLI_DEFAULT_LEVEL = KissLogger.Level.ERROR;

    /**
     *
     */
    public Main(String[] args) {

        logger = new KissLogger(CLI_DEFAULT_LEVEL);
        logger.info(APP_NAME + " v" + APP_VERSION);

        try {

            logger.info("Parsing CLI arguments");
            // Parse command line
            Options options = createOptions();
            CommandLineParser parser = new PosixParser();
            CommandLine cmd = parser.parse(options, args);

            // TODO Make some command line basic verification (ie "One OPT at least", "Only one OPT") #ABC

            // TODO Apply config file parameters

            if (cmd.hasOption(OPT_TECH_HELP)) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("diosmio-cli <option> [...]", options);

                // Normal end of application
                System.exit(0);
            }

            Properties properties = getApplicationProperties(cmd, DEFAULT_CONF_PATH);

            updateLogger(logger, properties, cmd);

            DiosMioJmxCli diosMioConnectedCli = new DiosMioJmxCli(properties.getProperty("server.rmi.url"),
                    properties.getProperty("server.rmi.domain_name"));

            ConsoleReader reader = new ConsoleReader();
            reader.setBellEnabled(false);
            reader.setDebug(new PrintWriter(new FileWriter(properties.getProperty("completion.debug_file"), true)));
            reader.setHistory(new History(new File(properties.getProperty("completion.history_file"))));

            reader.addCompletor(getCompletor());

            String line;
            PrintWriter out = new PrintWriter(System.out);
            out.println(APP_NAME + " v" + APP_VERSION);
            out.flush();

            while((line = reader.readLine(PROMPT)) != null) {
//                try {
                if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("exit")) {
                    break;
                }

                handleQuery(line, diosMioConnectedCli);
                out.flush();

//                } catch (Exception e) {
//                    System.err.println(e.getMessage());
//                    logger.error(e.getCause().toString());
//                    // On error, continue...
//                }
            }

            diosMioConnectedCli.close();

        } catch (Exception e) {
            System.err.println("A fatal error occurred: " + e.getMessage());
            System.err.println("See the logs for more detail.");
            logger.error(e);

        } finally {
            logger.close();
        }
    }

    public void handleQuery(String query, DiosMioCli diosMioCli) throws Exception, InstanceNotFoundException {

        Tree tree = null;

        // TODO let this Exception go up
        try {
            logger.debug("Creating ANTLRStringStream");
            ANTLRStringStream input = new ANTLRStringStream(query);

            logger.debug("Creating lexer");
            DiosMioCliLexer lexer = new DiosMioCliLexer(input);

            logger.debug("Creating token");
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            logger.debug("Creating parser");
            DiosMioCliParser parser = new DiosMioCliParser(tokens);

            logger.debug("Getting tree");
            // start parsing...
            tree = (Tree)(parser.parse().getTree());

        } catch(RecognitionException e) {
            System.out.println("Invalid query");
        }

        if (tree != null) {

            // TODO use business exception in 'throws'
            switch (tree.getType()) {
                case DiosMioCliParser.CMD_HELP:
                    System.out.println(usage);
                    break;

                // Artifact ***************************************************
                case DiosMioCliParser.CMD_ADD_ARTIFACT:
                    diosMioCli.createArtifact(tree.getChild(0).toString());
                    break;

                case DiosMioCliParser.CMD_GET_ARTIFACT:
                    if (tree.getChildCount() > 1) {
                        diosMioCli.showArtifact(new Long(tree.getChild(0).toString()));

                    } else {
                        diosMioCli.listAllArtifacts();
                    }
                    break;

                case DiosMioCliParser.CMD_DELETE_ARTIFACT:
                    diosMioCli.deleteArtifact(new Long(tree.getChild(0).toString()));
                    break;

                // Configuration **********************************************
                case DiosMioCliParser.CMD_ADD_CONFIG:
                    Main.logger.info("Main.handleQuery(CMD_ADD_CONFIG)");
                    diosMioCli.createConfiguration(tree.getChild(0).toString(),
                            tree.getChild(1).toString(),
                            tree.getChild(2).toString());
                    break;

                case DiosMioCliParser.CMD_GET_CONFIG:
                    if (tree.getChildCount() > 1) {
                        diosMioCli.readConfiguration(new Long(tree.getChild(0).toString()));
                    } else {

                    }
                    break;

                // Misc *******************************************************
                case DiosMioCliParser.CMD_LOAD:
                    loadFile(diosMioCli, tree.getChild(0).toString());
                    break;

                case DiosMioCliParser.CMD_PARSE:
                    parseFile(diosMioCli, tree.getChild(0).toString());
                    break;

                case DiosMioCliParser.CMD_NO_OP:
                    // Nothing to do
                    break;

                default:
                    // TODO throw exception?
                    System.out.println("Unknown action: " + tree.getType());
                    break;
            }
        }
    }

    private void loadFile(DiosMioCli diosMioCli, String filepath) throws Exception {
        diosMioCli.loadFile(filepath);
    }

    private void parseFile(DiosMioCli diosMioCli, String filepath) throws Exception {
        diosMioCli.parseFile(filepath);
    }

    private Completor getCompletor() {

        Completor helpCompletor = new SimpleCompletor("help");
        Completor elementCompletor = new SimpleCompletor(new String[] {"artifact", "config"});
        Completor filenameCompletor = new FileNameCompletor();

        Completor addCompletor = new ArgumentCompletor(
                new Completor[] {
                        new SimpleCompletor("add"),
                        elementCompletor,
                        filenameCompletor}
        );

        Completor getDeleteCompletor = new ArgumentCompletor(
                new Completor[] {
                        new SimpleCompletor(new String[] {"get", "delete"}),
                        elementCompletor
                }
        );

        Completor loadParseCompletor = new ArgumentCompletor(
                new Completor[] {
                        new SimpleCompletor(new String[] {"load", "parse"}),
                        filenameCompletor
                }
        );

        Completor rootCompletor = new MultiCompletor(
                new Completor[] {
                        helpCompletor,
                        addCompletor,
                        getDeleteCompletor,
                        loadParseCompletor}
        );

        return rootCompletor;
    }

    /**
     *
     * @param defaultFilePath
     * @return
     * @throws java.io.IOException
     * @throws Exception
     */
    public Properties getApplicationProperties(CommandLine cmd, String defaultFilePath) throws IOException, Exception {

        logger.info("Retrieving properties");

        InputStream is = null;

        if (cmd.hasOption(OPT_TECH_CONFIG_FILE)) {
            File f = new File(cmd.getOptionValue(OPT_TECH_CONFIG_FILE));
            if (f.exists() && f.canRead()) {
                logger.info("Using argument provided configuration file '" + f.getAbsolutePath() + "'");
                is = new FileInputStream(f);
            } else {
                logger.error("Cannot access argument specified configuration file '" + f.getAbsolutePath() + "'");
            }
        }

        if (is == null) {
            logger.info("Using default configuration file '" + defaultFilePath + "'");
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

        opt.addOption(OptionBuilder.hasArg()
                .hasOptionalArg()
                .withArgName("[level]")
                .withDescription("set verbosity at specified level (" + CLI_DEFAULT_LEVEL + " if no level is provided)")
                .withLongOpt(OPT_TECH_LOG_L)
                .create(OPT_TECH_LOG));

        opt.addOption(OptionBuilder.hasArg()
                .withArgName("file")
                .withDescription("use alternate log file")
                .withLongOpt(OPT_TECH_LOG_FILE_L)
                .create(OPT_TECH_LOG_FILE));

        opt.addOption(OptionBuilder.hasArg()
                .withArgName("file")
                .withDescription("use alternate config file")
                .withLongOpt(OPT_TECH_CONFIG_FILE_L)
                .create(OPT_TECH_CONFIG_FILE));

        return  opt;
    }

    private void updateLogger(KissLogger targetLogger, Properties properties, CommandLine cmd) {

        // TODO handle this in a more simple manner: one try catch?

        logger.info("Updating logger to reflect CLI or internal config");

        File logFile = null;

        // First, let's see if user provided CLI argument related to log file
        if (cmd.hasOption(OPT_TECH_LOG_FILE)) {
            logFile = new File(cmd.getOptionValue(OPT_TECH_LOG_FILE));
            if (logFile == null) {
                // TODO Should be checked earlier (see #ABC)
                logger.error("Bad file specified as argument for log file");
            } else {
                if (logFile.exists() && !logFile.canWrite()) {
                    logger.error("Cannot write to argument specified log file '" + "logFile.getAbsolutePath()" + "'");
                    logFile = null;
                } else {
                    logger.info("Found the following log file path given by argument '" + logFile.getAbsolutePath() + "'");
                }
            }
        }

        // No logFile! Let's see what config file says
        if (logFile == null) {
            String filePath = properties.getProperty("log.file");
            if (filePath == null) {
                logger.error("Cannot find any log file path in config file");
                logFile = null;
            } else {
                logFile = new File(filePath);
                if ((logFile == null) ||
                        (logFile.exists() && !logFile.canWrite()) ||
                        (!logFile.exists() && !logFile.getParentFile().canWrite())) {
                    logger.error("Cannot write to config specified log file '" + logFile.getAbsolutePath() + "'");
                    logFile = null;
                } else {
                    logger.info("Found the following log file path given in config file '" + logFile.getAbsolutePath() + "'");
                }
            }
        }

        if (logFile == null || !targetLogger.setDestination(logFile)) {
            logger.error("Still using console as error output. You should fix your config.");
        } else {
            logger.info("Switched log destination to " + logFile.getAbsolutePath());
        }

        // Now let's see if user provided arguments about the log level
        KissLogger.Level logLevel = null;

        if (cmd.hasOption(OPT_TECH_LOG)) {
            logLevel = KissLogger.Level.getLevel(cmd.getOptionValue(OPT_TECH_LOG));
            if (logLevel == null) {
                logger.error("Incorrect log level specified as argument: '" + cmd.getOptionValue(OPT_TECH_LOG) + "'");
            } else {
                logger.info("Found the following log level passed as argument '" + logLevel.name() + "'");
            }
        }

        // No loglevel. Let's see what config file says
        if (logLevel == null) {
            logLevel = KissLogger.Level.getLevel(properties.getProperty("log.level"));

            if (logLevel == null) {
                logger.error("No valid log level specified in config file.");
            } else {
                logger.info("Found the following log level in config file '" + logLevel.name() + "'");
            }
        }

        if (logLevel != null) {
            logger.info("Switching log level to " + logLevel);
            logger.setLevel(logLevel);
        }
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

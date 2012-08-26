package net.alaux.diosmio.ui.cli;

import jline.*;
import net.alaux.diosmio.ui.cli.antlr.DiosMioCliLexer;
import net.alaux.diosmio.ui.cli.antlr.DiosMioCliParser;
import net.alaux.diosmio.ui.cli.jmx.DiosMioJmxCli;
import net.alaux.diosmio.ui.cli.logging.KissLogger;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.apache.commons.cli.*;

import java.io.*;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.ResourceBundle;

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

    private static final String DEFAULT_CONF_PATH = "diosmio-cli.conf";

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


    public static final KissLogger.Level CLI_DEFAULT_LEVEL = KissLogger.Level.DEBUG;
    public static final KissLogger logger = new KissLogger(CLI_DEFAULT_LEVEL);

    public static final ResourceBundle bundle = ResourceBundle.getBundle("messages/messages");

    public static final PrintWriter out = new PrintWriter(System.out, true);
    // For now let's write error output to regular "out" output. Later, TODO think about a colorized err output?
    public static final PrintWriter err = out;

    /**
     *
     */
    public Main(String[] args) {

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

            Properties properties = getCliProperties(cmd, DEFAULT_CONF_PATH);

            updateCliLogger(logger, properties, cmd);

            DiosMioJmxCli diosMioConnectedCli = new DiosMioJmxCli(properties.getProperty("server.rmi.url"),
                    properties.getProperty("server.rmi.domain_name"));

            ConsoleReader reader = new ConsoleReader();
            reader.setBellEnabled(false);
            reader.setDebug(new PrintWriter(new FileWriter(properties.getProperty("completion.debug_file"), true)));
            reader.setHistory(new History(new File(properties.getProperty("completion.history_file"))));

            reader.addCompletor(getCompletor());

            String line;
            out.println(APP_NAME + " v" + APP_VERSION);
            out.flush();

            while((line = reader.readLine(PROMPT)) != null) {
                try {
                    if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("exit")) {
                        break;
                    }

                    handleQuery(line, diosMioConnectedCli);
                    out.flush();

                } catch (RuntimeException e) {
                    out.println(e.getMessage());
                    logger.logException(e);
                    // On error, continue...
                }
            }

            diosMioConnectedCli.close();

        } catch (Exception e) {
            Main.err.println("A fatal error occurred: " + e);
            Main.err.println("See the logs for more detail.");
            logger.logException(e);

        } finally {
            logger.info("Done.\n");
            logger.close();
        }

    }

    public void handleQuery(String query, DiosMioCli diosMioCli) {

        Tree tree;

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
        try {
            tree = (Tree)(parser.parse().getTree());
        } catch (RecognitionException e) {
            throw new RuntimeException(bundle.getString("error.antlr.parse"), e);
        }

        if (tree != null) {

            // TODO use business exception in 'throws'
            switch (tree.getType()) {
                case DiosMioCliParser.CMD_HELP:
                    out.println(usage);
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
                    diosMioCli.loadFile(tree.getChild(0).toString());
                    break;

                case DiosMioCliParser.CMD_PARSE:
                    diosMioCli.parseFile(tree.getChild(0).toString());
                    break;

                case DiosMioCliParser.CMD_NO_OP:
                    // Nothing to do
                    break;
            }
        }
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


    // TODO This method is too complicated (too many if, try, then, else, etc). Clean it
    public Properties getCliProperties(CommandLine cmd, String defaultFilePath) {

        logger.info("Retrieving properties");

        InputStream is = null;

        if (cmd.hasOption(OPT_TECH_CONFIG_FILE)) {
            File f = new File(cmd.getOptionValue(OPT_TECH_CONFIG_FILE));
            if (f.exists() && f.canRead()) {
                logger.info("Using argument provided configuration file '" + f.getAbsolutePath() + "'");
                try {
                    is = new FileInputStream(f);
                } catch (FileNotFoundException e) {
                    Main.err.println(MessageFormat.format(bundle.getString("error.access.read.argument"), cmd.getOptionValue(OPT_TECH_CONFIG_FILE)));
                    logger.error("Cannot access argument specified configuration file '" + cmd.getOptionValue(OPT_TECH_CONFIG_FILE) + "'");
                }
            } else {
                Main.err.println(MessageFormat.format(bundle.getString("error.access.read.argument"), cmd.getOptionValue(OPT_TECH_CONFIG_FILE)));
                logger.error("Cannot access argument specified configuration file '" + cmd.getOptionValue(OPT_TECH_CONFIG_FILE) + "'");
            }
        }

        if (is == null) {
            logger.info("Using default configuration file '" + defaultFilePath + "'");
            is = ClassLoader.getSystemClassLoader().getResourceAsStream(defaultFilePath);
        }

        if (is == null) {
            // TODO Handle this properly
            throw new Error(bundle.getString("error.no_config_file"));
        }

        Properties res =  new Properties();
        try {
            res.load(is);
        } catch (IOException e) {
            throw new Error(bundle.getString("error.no_config_file"));
        }

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

    private void updateCliLogger(KissLogger targetLogger, Properties properties, CommandLine cmd) {

        // TODO handle this in a more simple manner: one try catch?

        logger.info("Updating logger to reflect CLI or internal config");

        File logFile = null;

        // First, let's see if user provided CLI argument related to log file
        if (cmd.hasOption(OPT_TECH_LOG_FILE)) {
            logFile = new File(cmd.getOptionValue(OPT_TECH_LOG_FILE));
            if (logFile == null) {
                // TODO Should be checked earlier (see #ABC)
                err.println(MessageFormat.format(bundle.getString("error.access.write.argument"), cmd.getOptionValue(OPT_TECH_LOG_FILE)));
                logger.error("Cannot write to argument specified log file '" + cmd.getOptionValue(OPT_TECH_LOG_FILE) + "'");
            } else {
                if (logFile.exists() && !logFile.canWrite()) {
                    err.println(MessageFormat.format(bundle.getString("error.access.write.argument"), logFile.getAbsolutePath()));
                    logger.error("Cannot write to argument specified log file '" + logFile.getAbsolutePath() + "'");
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
                err.println(bundle.getString("error.config.no_logfile"));
                logger.error("Cannot find any log file path in config file");
                logFile = null;
            } else {
                logFile = new File(filePath);
                if ((logFile == null) ||
                        (logFile.exists() && !logFile.canWrite()) ||
                        (!logFile.exists() && !logFile.getParentFile().canWrite())) {
                    err.println(MessageFormat.format(bundle.getString("error.access.write"), filePath));
                    logger.error("Cannot write to config specified log file '" + filePath + "'");
                    logFile = null;
                } else {
                    logger.info("Found the following log file path given in config file '" + logFile.getAbsolutePath() + "'");
                }
            }
        }

        PrintStream printStream;
        try {
            printStream = new PrintStream(new FileOutputStream(logFile, true));

            if (printStream != null && !printStream.checkError() && targetLogger.switchDestination(printStream)) {
                logger.info("Switched log destination to " + logFile.getAbsolutePath());
            } else {
                err.println(MessageFormat.format(bundle.getString("error.access.write"), logFile));
                out.println(bundle.getString("info.logging_to_default"));
                logger.error("Still using console as error output. You should fix your config.");
            }
        } catch (FileNotFoundException e) {
            // Nothing to do
        }

        // Now let's see if user provided arguments about the log level
        KissLogger.Level logLevel = null;

        if (cmd.hasOption(OPT_TECH_LOG)) {
            logLevel = KissLogger.Level.getLevel(cmd.getOptionValue(OPT_TECH_LOG));
            if (logLevel == null) {
                err.println(MessageFormat.format(bundle.getString("error.config.incorrect_log_level"), cmd.getOptionValue(OPT_TECH_LOG)));
                logger.error("Incorrect log level specified as argument: '" + cmd.getOptionValue(OPT_TECH_LOG) + "'");
            } else {
                logger.info("Found the following log level passed as argument '" + logLevel.name() + "'");
            }
        }

        // No loglevel. Let's see what config file says
        if (logLevel == null) {
            logLevel = KissLogger.Level.getLevel(properties.getProperty("log.level"));

            if (logLevel == null) {
                err.println(bundle.getString("error.config.no_log_level"));
                logger.error("No valid log level specified in config file.");
            } else {
                logger.info("Found the following log level in config file '" + logLevel.name() + "'");
            }
        }

        if (logLevel != null) {
            logger.info("Switching log level from " + logger.getLevel() + " to " + logLevel);
            logger.setLevel(logLevel);
        }
    }

    public static void main(String[] args) {

        Main main = new Main(args);
    }
}

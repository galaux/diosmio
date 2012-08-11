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

    private static final String OPT_TECH_LOG_WARN = "v";
    private static final String OPT_TECH_LOG_INFO = "vv";
    private static final String OPT_TECH_LOG_DEBUG = "vvv";

    public static final String OPT_TECH_CONFIG_FILE_L = "conf";
    public static final String OPT_TECH_CONFIG_FILE = "c";

    // TODO Get this value from config file
    private static final String DIOSMIOCLI_LOG_PATH = "/tmp/diosmio-cli.log";


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

    KissLogger logger;

    private static final String[] commands = {
            "help",

            "add artifact",
            "show artifact",
            "delete artifact",

//            "add config",
//            "show config",
//            "show configs",
//            "delete config"
    };

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

            // TODO Apply config file parameters

            if (cmd.hasOption(OPT_TECH_HELP)) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("diosmio-cli <option> [...]", options);

                // Normal end of application
                System.exit(0);
            }

            Properties properties = getApplicationProperties(cmd.getOptionValue(OPT_TECH_CONFIG_FILE), DEFAULT_CONF_PATH);

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
                try {
                    if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("exit")) {
                        break;
                    }

                    handleQuery(line, diosMioConnectedCli);
                    out.flush();

                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    // On error, continue...
                }
            }

            diosMioConnectedCli.close();

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

    public void handleQuery(String query, DiosMioCli diosMioCli) throws Exception, InstanceNotFoundException {

        Tree tree = null;

        // TODO let this Exception go up
        try {
            ANTLRStringStream input = new ANTLRStringStream(query);

            DiosMioCliLexer lexer = new DiosMioCliLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            DiosMioCliParser parser = new DiosMioCliParser(tokens);

            // start parsing...
            tree = (Tree)(parser.parse().getTree());

        } catch(RecognitionException e) {
            System.out.println("Invalid query");
        }

        String element = null;
        Long id = null;
        String filePath = null;

        if (tree != null) {
            // TODO use business exception in 'throws'
            switch (tree.getType()) {
                case DiosMioCliParser.HELP:
                    System.out.println(usage);
                    break;

                case DiosMioCliParser.ADD:
                    element = tree.getChild(0).toString();
                    filePath = tree.getChild(1).toString();

                    addElement(diosMioCli, element, filePath);
                    break;

                case DiosMioCliParser.GET:
                    element = tree.getChild(0).toString();
                    if (tree.getChildCount() > 1) {
                        id = new Long(tree.getChild(1).toString());
                    }

                    getElement(diosMioCli, element, id);
                    break;

                case DiosMioCliParser.DELETE:
                    element = tree.getChild(0).toString();
                    id = new Long(tree.getChild(1).toString());

                    deleteElement(diosMioCli, element, id);
                    break;

                case DiosMioCliParser.LOAD:
                    filePath = tree.getChild(0).toString();
                    loadFile(diosMioCli, filePath);
                    break;

                case DiosMioCliParser.PARSE:
                    filePath = tree.getChild(0).toString();
                    parseFile(diosMioCli, filePath);
                    break;

                case DiosMioCliParser.NO_OP:
                    // Nothing to do
                    break;

                default:
                    System.out.println("Unknown action: " + tree.getType());
                    break;
            }
        }
    }

    private void addElement(DiosMioCli diosMioCli, String element, String filePath) throws Exception {
        if (ELEMENT_ARTIFACT.compareTo(element) == 0) {
            diosMioCli.createArtifact(filePath);

        } else if (ELEMENT_CONFIG.compareTo(element) == 0) {
            System.out.println("TO BE IMPLEMENTED: add(" + element + ", " + filePath + ")");

        } else {
            throw new Exception("Unknown element '" + element + "'");
        }
    }

    private void getElement(DiosMioCli diosMioCli, String element, Long id) throws Exception {
        if (ELEMENT_ARTIFACT.compareTo(element) == 0) {
            if (id == null) {
                diosMioCli.listAllArtifacts();
            } else {
                diosMioCli.showArtifact(id);
            }

        } else if (ELEMENT_CONFIG.compareTo(element) == 0) {
            if (id == null) {
                System.out.println("TO BE IMPLEMENTED: getAll(" + element + ")");
            } else {
                System.out.println("TO BE IMPLEMENTED: get(" + element + ", " + id + ")");
            }

        } else {
            throw new Exception("Unknown element '" + element + "'");
        }
    }

    private void deleteElement(DiosMioCli diosMioCli, String element, Long id) throws Exception {
        if (ELEMENT_ARTIFACT.compareTo(element) == 0) {
            diosMioCli.deleteArtifact(id);

        } else if (ELEMENT_CONFIG.compareTo(element) == 0) {
            System.out.println("delete(" + element + ", " + id + ")");

        } else {
            throw new Exception("Unknown element '" + element + "'");
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
     * @param filePath
     * @param defaultFilePath
     * @return
     * @throws java.io.IOException
     * @throws Exception
     */
    public Properties getApplicationProperties(String filePath, String defaultFilePath) throws IOException, Exception {

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

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) {

        Main main = new Main(args);
    }
}

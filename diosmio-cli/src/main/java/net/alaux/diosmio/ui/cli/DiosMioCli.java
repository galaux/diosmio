package net.alaux.diosmio.ui.cli;

import net.alaux.diosmio.ui.cli.core.CliArtifactManagerActions;
import net.alaux.diosmio.ui.cli.core.CliMiscActions;
import org.apache.commons.cli.*;

import javax.management.*;
import java.io.IOException;


/**
 * Hello world!
 *
 */
public class DiosMioCli {


//    private static final String DM_BEAN_ARTF_MNG_FS_NAME = "net.alaux.diosmio:name=fileSystemArtifactManager";
//    private static final String DM_BEAN_ARTF_MNG_FS_NAME = "fileSystemArtifactManager";

//	@Resource(name = "sayHello")
//	SaySomething saySomething;

    private static Options options;
    private static DiosMioCli cli;

    private static final String DM_CLI_VERSION = "1.0-SNAPSHOT";

    // Misc
    private static final String OPT_MISC_HELP = "h";
    private static final String OPT_MISC_HELP_L = "help";

    private static final String OPT_MISC_SHOW_BEANS = "s";
    private static final String OPT_MISC_SHOW_BEANS_L = "show-beans";

    // Artifact Manager
    private static final String OPT_ARTIF_MNGR_ADD = "a";
    private static final String OPT_ARTIF_MNGR_ADD_L = "add-artifact";

    public static final String OPT_ARTIF_MNGR_LIST = "l";
    public static final String OPT_ARTIF_MNGR_LIST_L = "list-artifacts";

    public static final String OPT_ARTIF_MNGR_DEL = "d";
    public static final String OPT_ARTIF_MNGR_DEL_L = "delete-artifact";


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

            // Misc
            options.addOption(OPT_MISC_HELP, false, "give this help");
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

            // Misc *******************************************
            if (cmd.hasOption(OPT_MISC_HELP)) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("diosmio-cli <option> [...]", options);
            } else if (cmd.hasOption(OPT_MISC_SHOW_BEANS)) {
                CliMiscActions.displayMBeanList();

                // Artifact Manager ***************************
            } else if (cmd.hasOption(OPT_ARTIF_MNGR_LIST)) {
                CliArtifactManagerActions.listArtifacts();
            } else if (cmd.hasOption(OPT_ARTIF_MNGR_ADD)) {
                CliArtifactManagerActions.addArtifact(cmd.getOptionValue(OPT_ARTIF_MNGR_ADD));
            } else if (cmd.hasOption(OPT_ARTIF_MNGR_DEL)) {
                CliArtifactManagerActions.deleteArtifact(cmd.getOptionValue(OPT_ARTIF_MNGR_DEL));
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) {
        cli = new DiosMioCli(args);
    }
}

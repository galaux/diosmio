package net.alaux.diosmio.ui.cli.jmxcli;

import net.alaux.diosmio.ui.cli.DiosMioCli;

import javax.management.InstanceNotFoundException;
import javax.management.MalformedObjectNameException;

// TODO Make CLI classes throw AppExceptions instead of raw Exception

public class DiosMioJmxCli implements DiosMioCli {

    // TODO REmove if unused
//    private String jmxUrl;
//    protected String domainName;
//
//    public static KissLogger logger;
//
//
//    public DiosMioJmxCli(String jmxUrl, String domainName, KissLogger logger) {
//        this.jmxUrl = jmxUrl;
//        this.domainName = domainName;
//        this.logger = logger;
//    }
//
//    public void displayMBeanList() throws IOException, MalformedObjectNameException {
//        CliMiscJmxActions cliMiscJmxActions = new CliMiscJmxActions(jmxUrl, domainName);
//        cliMiscJmxActions.displayMBeanList();
//        cliMiscJmxActions.closeJmxConnection();
//    }
//
//    public void displayStatus() throws Exception {
//        CliMiscJmxActions cliMiscJmxActions = new CliMiscJmxActions(jmxUrl, domainName);
//        cliMiscJmxActions.displayStatus();
//        cliMiscJmxActions.closeJmxConnection();
//    }
//
//    public void listAllArtifacts() throws IOException, MalformedObjectNameException, InstanceNotFoundException {
//        CliArtifactManagerJmxActions cliArtifactManagerJmxActions = new CliArtifactManagerJmxActions(jmxUrl, domainName);
//        cliArtifactManagerJmxActions.listAllArtifacts();
//        cliArtifactManagerJmxActions.closeJmxConnection();
//    }
//
//    public void showArtifact(Long id) throws IOException, MalformedObjectNameException, InstanceNotFoundException {
//        CliArtifactManagerJmxActions cliArtifactManagerJmxActions = new CliArtifactManagerJmxActions(jmxUrl, domainName);
//        cliArtifactManagerJmxActions.showArtifact(id);
//        cliArtifactManagerJmxActions.closeJmxConnection();
//    }
//
//    public void createArtifact(String filePath) throws Exception {
//        // TODO Make all the check about the file in the Main.java
//        CliArtifactManagerJmxActions cliArtifactManagerJmxActions = new CliArtifactManagerJmxActions(jmxUrl, domainName);
//        cliArtifactManagerJmxActions.create(filePath);
//        cliArtifactManagerJmxActions.closeJmxConnection();
//    }
//
//    public void deleteArtifact(Long id) throws Exception, MalformedObjectNameException, InstanceNotFoundException {
//        CliArtifactManagerJmxActions cliArtifactManagerJmxActions = new CliArtifactManagerJmxActions(jmxUrl, domainName);
//        cliArtifactManagerJmxActions.delete(id);
//        cliArtifactManagerJmxActions.closeJmxConnection();
//    }
//
//    public void loadFile(String file) throws Exception {
//        //To change body of implemented methods use File | Settings | File Templates.
//    }
//
//    public void parseFile(String file) throws Exception {
//        //To change body of implemented methods use File | Settings | File Templates.
//    }

    public void displayStatus() throws Exception {
        throw new Exception("Oups... finalement on s'en sert");
    }

    public void listAllArtifacts() throws Exception, MalformedObjectNameException, InstanceNotFoundException {
        throw new Exception("Oups... finalement on s'en sert");
    }

    public void showArtifact(Long id) throws Exception, MalformedObjectNameException, InstanceNotFoundException {
        throw new Exception("Oups... finalement on s'en sert");
    }

    public void createArtifact(String filePath) throws Exception, MalformedObjectNameException, InstanceNotFoundException {
        throw new Exception("Oups... finalement on s'en sert");
    }

    public void deleteArtifact(Long id) throws Exception, MalformedObjectNameException, InstanceNotFoundException {
        throw new Exception("Oups... finalement on s'en sert");
    }

    public void loadFile(String filePath) throws Exception {
        throw new Exception("Oups... finalement on s'en sert");
    }

    public void parseFile(String filePath) throws Exception {
        throw new Exception("Oups... finalement on s'en sert");
    }
}

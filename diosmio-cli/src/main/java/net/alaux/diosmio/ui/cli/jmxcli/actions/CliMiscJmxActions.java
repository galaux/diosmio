package net.alaux.diosmio.ui.cli.jmxcli.actions;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/7/12
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class CliMiscJmxActions extends CliJmxActions {

//    public CliMiscJmxActions(String jmxUrl, String domainName) throws IOException{
//        super(jmxUrl, domainName);
//    }
//
//    public void displayMBeanList() throws IOException, MalformedObjectNameException {
//
//        Set<ObjectName> names = new TreeSet<ObjectName>(mbsc.queryNames(null, null));
//
//        for (ObjectName name : names) {
//            if (name.toString().startsWith(this.domainName)) {
//                System.out.println(name.toString().replaceFirst(this.domainName + ":name=", ""));
//            }
//        }
//    }
//
//    public void displayStatus() throws Exception {
//
//        // Check artifactManager
//        ArtifactManager artifactManager = getServiceBean(ArtifactManager.class);
//        if (artifactManager == null) {
//            System.out.println("Artifact manager: null");
//
//        } else {
//            System.out.println("Artifact Manager: " + (artifactManager.getStatus() ? "OK" : "ERROR"));
//        }
//    }
}

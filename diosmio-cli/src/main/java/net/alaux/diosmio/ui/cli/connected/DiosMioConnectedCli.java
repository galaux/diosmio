package net.alaux.diosmio.ui.cli.connected;

import net.alaux.diosmio.services.core.ArtifactManager;
import net.alaux.diosmio.services.entity.Artifact;
import net.alaux.diosmio.ui.cli.DiosMioCli;
import net.alaux.diosmio.ui.cli.jmxcli.DiosMioJmxConnection;

import javax.management.InstanceNotFoundException;
import javax.management.MalformedObjectNameException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 8/4/12
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class DiosMioConnectedCli implements DiosMioCli {

    private String url;
    private String domain;

    private DiosMioJmxConnection diosMioJmxConnection;

    private ArtifactManager artifactManager;

    public DiosMioConnectedCli(String url, String domain) throws IOException, MalformedObjectNameException, InstanceNotFoundException {

        this.url = url;
        this.domain = domain;
    }

    public void close() throws IOException {
        if (diosMioJmxConnection != null) {
            diosMioJmxConnection.closeJmxConnection();
        }
    }

    private DiosMioJmxConnection getJmxConnection() throws IOException {
        if (diosMioJmxConnection == null) {
            diosMioJmxConnection = new DiosMioJmxConnection(url, domain);
        }

        return diosMioJmxConnection;
    }

    public ArtifactManager getArtifactManager() throws MalformedObjectNameException, InstanceNotFoundException, IOException {
        if (artifactManager == null) {
            artifactManager = getJmxConnection().getServiceBean(ArtifactManager.class);
        }
        return artifactManager;
    }

//    public void displayMBeanList() throws IOException, MalformedObjectNameException {
//        //To change body of implemented methods use File | Settings | File Templates.
//    }

    public void displayStatus() throws Exception {
        System.out.println(getArtifactManager().getStatus());
    }

    public void listAllArtifacts() throws IOException, MalformedObjectNameException, InstanceNotFoundException {

        List<Artifact> artifacts = getArtifactManager().getAll();

        for (Artifact artifact : artifacts) {
            System.out.println(artifact);
        }
    }

    public void showArtifact(Long id) throws IOException, MalformedObjectNameException, InstanceNotFoundException {

        Artifact artifact = getArtifactManager().get(id);
        if (artifact != null) {
            System.out.println(artifact);
        } else {
            System.out.println("Artifact not found");
        }
    }

    public void createArtifact(String filePath) throws Exception, MalformedObjectNameException, InstanceNotFoundException {

        File artifactFile = new File(filePath);
        if (artifactFile == null || !artifactFile.canRead()) {
            throw new Exception("cli.error.cannot_read_file");
        }

        FileInputStream fis = new FileInputStream(artifactFile);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        for (int readNum; (readNum = fis.read(buf)) != -1;) {
            bos.write(buf, 0, readNum);
        }

        getArtifactManager().create(artifactFile.getName(), bos.toByteArray());
    }

    public void deleteArtifact(Long id) throws Exception, MalformedObjectNameException, InstanceNotFoundException {

        Artifact artifact = getArtifactManager().get(id);

        if (artifact == null) {
            System.out.println("Cannot find artifact");
        } else {
            artifactManager.delete(artifact);
            System.out.println("Artifact deleted");
        }
    }
}

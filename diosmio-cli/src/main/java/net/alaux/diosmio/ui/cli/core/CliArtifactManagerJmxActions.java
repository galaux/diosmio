package net.alaux.diosmio.ui.cli.core;

import net.alaux.diosmio.core.services.IArtifactManager;

import javax.management.InstanceNotFoundException;
import javax.management.MalformedObjectNameException;
import java.io.*;
import java.util.Arrays;

public class CliArtifactManagerJmxActions extends CliJmxActions {

    public CliArtifactManagerJmxActions() throws IOException{
        super();
    }

    // TODO handle Exception
    public void addArtifact(String arg) throws IOException, InstanceNotFoundException, MalformedObjectNameException, Exception {

        IArtifactManager artifactManager = getServiceBean(IArtifactManager.class);

        File artifact = new File(arg);
        if (artifact == null || !artifact.canRead()) {
            throw new Exception("cli.error.cannot_read_file");
        }

        FileInputStream fis = new FileInputStream(artifact);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        for (int readNum; (readNum = fis.read(buf)) != -1;) {
            bos.write(buf, 0, readNum);
        }

        artifactManager.addArtifact(artifact.getName(), bos.toByteArray());
    }

    public void listArtifacts() throws IOException, InstanceNotFoundException, MalformedObjectNameException {

        IArtifactManager artifactManager = getServiceBean(IArtifactManager.class);

        File[] artifactList = artifactManager.listArtifacts();

        Arrays.sort(artifactList);
        for (File artifact : artifactList) {
            System.out.println(artifact.getName());
        }
    }

    /**
     * For now, let's just identify a file based on its filename
     * @param arg
     * @return
     * @throws IOException
     * @throws InstanceNotFoundException
     * @throws MalformedObjectNameException
     */
    // TODO handle "Exception" as BusinessExceptin
    public void deleteArtifact(String arg) throws IOException, InstanceNotFoundException, MalformedObjectNameException, Exception  {

        IArtifactManager artifactManager = getServiceBean(IArtifactManager.class);

        if (artifactManager.deleteArtifact(arg)) {
            System.out.println("Artifact deleted");
        }   else {
            System.out.println("Could not delete artifact");
        }
    }
}

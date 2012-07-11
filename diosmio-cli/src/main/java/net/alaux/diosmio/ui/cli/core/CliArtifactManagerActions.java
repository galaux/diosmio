package net.alaux.diosmio.ui.cli.core;

import net.alaux.diosmio.core.services.IArtifactManager;
import net.alaux.diosmio.ui.cli.ClientListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.IOUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.management.InstanceNotFoundException;
import javax.management.JMX;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.io.*;
import java.util.Arrays;

public class CliArtifactManagerActions extends CliActions {

    // TODO handle Exception
    public void addArtifact(String arg) throws IOException, InstanceNotFoundException, MalformedObjectNameException, Exception {

        initJmxConnection();

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

        closeJmxConnection();
    }

    public void listArtifacts() throws IOException, InstanceNotFoundException, MalformedObjectNameException {

        initJmxConnection();

        IArtifactManager artifactManager = getServiceBean(IArtifactManager.class);

        File[] artifactList = artifactManager.listArtifacts();

        Arrays.sort(artifactList);
        for (File artifact : artifactList) {
            System.out.println(artifact.getName());
        }

        closeJmxConnection();
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

        initJmxConnection();

        IArtifactManager artifactManager = getServiceBean(IArtifactManager.class);

        if (artifactManager.deleteArtifact(arg)) {
            System.out.println("Artifact deleted");
        }   else {
            System.out.println("Could not delete artifact");
        }

        closeJmxConnection();
    }
}

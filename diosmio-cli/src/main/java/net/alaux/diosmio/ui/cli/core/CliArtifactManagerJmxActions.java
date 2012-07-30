package net.alaux.diosmio.ui.cli.core;

import net.alaux.diosmio.core.entity.Artifact;
import net.alaux.diosmio.core.entity.impl.JavaWar;
import net.alaux.diosmio.core.persistence.dao.file.FileDao;
import net.alaux.diosmio.core.service.ArtifactManager;

import javax.management.InstanceNotFoundException;
import javax.management.MalformedObjectNameException;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class CliArtifactManagerJmxActions extends CliJmxActions {

    public CliArtifactManagerJmxActions() throws IOException{
        super();
    }

    // TODO handle Exception
    public void create(String arg) throws IOException, InstanceNotFoundException, MalformedObjectNameException, Exception {

        ArtifactManager artifactManager = getServiceBean(ArtifactManager.class);

        File artifactFile = new File(arg);
        if (artifactFile == null || !artifactFile.canRead()) {
            throw new Exception("cli.error.cannot_read_file");
        }

        FileInputStream fis = new FileInputStream(artifactFile);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        for (int readNum; (readNum = fis.read(buf)) != -1;) {
            bos.write(buf, 0, readNum);
        }

        artifactManager.create(artifactFile.getName(), bos.toByteArray());
    }

    public void getAll() throws IOException, InstanceNotFoundException, MalformedObjectNameException {

        ArtifactManager artifactManager = getServiceBean(ArtifactManager.class);

        List<Artifact> artifacts = artifactManager.getAll();

        for (Artifact artifact : artifacts) {
            System.out.println(artifact.getId() + " " + artifact.getName());
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
    public void delete(String arg) throws IOException, InstanceNotFoundException, MalformedObjectNameException, Exception  {

        FileDao artifactManager = getServiceBean(FileDao.class);

        if (artifactManager.delete(arg)) {
            System.out.println("Artifact deleted");
        }   else {
            System.out.println("Could not delete artifact");
        }
    }
}

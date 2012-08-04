package net.alaux.diosmio.ui.cli.core;

import net.alaux.diosmio.services.core.ArtifactManager;
import net.alaux.diosmio.services.entity.Artifact;
import net.alaux.diosmio.ui.cli.DiosMioCli;

import javax.management.InstanceNotFoundException;
import javax.management.MalformedObjectNameException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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

    public void showArtifact(Long id) throws IOException, InstanceNotFoundException, MalformedObjectNameException {

        ArtifactManager artifactManager = getServiceBean(ArtifactManager.class);
        Artifact artifact = artifactManager.get(id);
        if (artifact != null) {
            System.out.println(artifact);
        } else {
            System.out.println("Artifact not found");
        }
    }

    public void listAllArtifacts() throws IOException, InstanceNotFoundException, MalformedObjectNameException {

        DiosMioCli.logger.info("listAllArtifacts");
        DiosMioCli.logger.info("Getting service bean");

        ArtifactManager artifactManager = getServiceBean(ArtifactManager.class);

        DiosMioCli.logger.info("invoking 'artifactManager.getAll'");

        List<Artifact> artifacts = artifactManager.getAll();

        DiosMioCli.logger.info("Displaying result");

        for (Artifact artifact : artifacts) {
            System.out.println(artifact);
        }
        DiosMioCli.logger.info("Done.");
    }

    /**
     *
     * @param id
     * @throws IOException
     * @throws InstanceNotFoundException
     * @throws MalformedObjectNameException
     * @throws Exception
     */
    // TODO handle "Exception" as BusinessExceptin
    public void delete(Long id) throws IOException, InstanceNotFoundException, MalformedObjectNameException, Exception  {

        ArtifactManager artifactManager = getServiceBean(ArtifactManager.class);
        Artifact artifact = artifactManager.get(id);

        if (artifact == null) {
            System.out.println("Cannot find artifact");
        } else {
            artifactManager.delete(artifact);
            System.out.println("Artifact deleted");
        }
    }
}

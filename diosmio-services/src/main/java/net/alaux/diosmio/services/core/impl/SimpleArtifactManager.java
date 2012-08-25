package net.alaux.diosmio.services.core.impl;

import net.alaux.diosmio.services.AppMessages;
import net.alaux.diosmio.services.core.ArtifactManager;
import net.alaux.diosmio.services.dao.db.impl.ArtifactDao;
import net.alaux.diosmio.services.dao.file.FileDao;
import net.alaux.diosmio.services.entity.Artifact;
import net.alaux.utils.AppException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

/**
 * User: miguel
 * Date: 7/26/12
 */
public class SimpleArtifactManager implements ArtifactManager {

    @Autowired
    private ArtifactDao artifactDao;

    @Autowired
    private FileDao fileDao;

    @Autowired
    private AppMessages diosMioMessage;

    public static final String FILE_SEPARATOR   = System.getProperty("file.separator");

    public Log logger = LogFactory.getLog(SimpleArtifactManager.class);

    public boolean getStatus() {
        return (artifactDao != null)
                && (artifactDao.getStatus())
                && (fileDao != null)
                && (fileDao.getStatus());
    }

    public boolean getDbDaoStatus() {
        return artifactDao.getStatus();
    }

    public boolean getFileDaoStatus() {
        return fileDao.getStatus();
    }

    public Artifact create(String name, byte[] content) throws AppException, IOException {
        logger.info("create()");

        /*
         TODO some sort of transaction: if "fileDao.create(artifact, content);" fails
         then remove the Artifact from the artifactDao too!
          */
        Artifact artifact = new Artifact(name, FILE_SEPARATOR);
        artifactDao.create(artifact);

        fileDao.create(artifact, content);

        return artifact;
    }

    public Artifact get(Long id) {
        logger.info("get()");
        return artifactDao.get(id);
    }

    public List<Artifact> getAll() {
        logger.info("getAll()");
        return artifactDao.getAll();
    }

    public void delete(Artifact artifact) throws AppException {
        logger.info("delete()");
        fileDao.delete(artifact);
        artifactDao.delete(artifact);
    }
}

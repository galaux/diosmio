package net.alaux.diosmio.services.core.impl;

import net.alaux.diosmio.common.AppProperties;
import net.alaux.diosmio.services.core.ArtifactManager;
import net.alaux.diosmio.services.dao.db.impl.ArtifactDao;
import net.alaux.diosmio.services.dao.file.FileDao;
import net.alaux.diosmio.services.entity.Artifact;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/26/12
 * Time: 10:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleArtifactManager implements ArtifactManager {

    @Autowired
    private ArtifactDao artifactDao;

    @Autowired
    private FileDao fileDao;

    @Autowired
    AppProperties appProperties;

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

    public Artifact create(String internPath, byte[] content) throws Exception {
        logger.info("create");

        Artifact artifact = new Artifact(internPath, "/");
        artifactDao.create(artifact);

        fileDao.create(internPath, content);

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

    public void delete(Artifact artifact) throws Exception {
        logger.info("delete()");
        fileDao.delete(artifact.getRelativePath() + appProperties.FILE_SEPARATOR + artifact.getName());
        artifactDao.delete(artifact);
    }
}

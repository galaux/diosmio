package net.alaux.diosmio.core.service.impl;

import net.alaux.diosmio.core.entity.Artifact;
import net.alaux.diosmio.core.persistence.dao.db.impl.ArtifactDao;
import net.alaux.diosmio.core.persistence.dao.file.FileDao;
import net.alaux.diosmio.core.service.ArtifactManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public Logger logger = LoggerFactory.getLogger(SimpleArtifactManager.class);

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
        System.out.println("create");

        Artifact artifact = new Artifact(internPath, "/");
        artifactDao.create(artifact);

        fileDao.create(internPath, content);

        return artifact;
    }

    public Artifact get(Long id) {
        System.out.println("get()");
        return artifactDao.get(id);
    }

    public List<Artifact> getAll() {
        System.out.println("getAll()");
        return artifactDao.getAll();
    }

    public boolean delete(Long id) throws Exception {
        System.out.println("delete()");
        // TODO
//        artifactDao.delete(id);
        return false;
    }
}

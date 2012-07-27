package net.alaux.diosmio.core.service.impl;

import net.alaux.diosmio.core.entity.Artifact;
import net.alaux.diosmio.core.entity.impl.JavaWar;
import net.alaux.diosmio.core.persistence.dao.db.DatabaseDao;
import net.alaux.diosmio.core.persistence.dao.file.FileDao;
import net.alaux.diosmio.core.service.ArtifactManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/26/12
 * Time: 10:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleArtifactManager implements ArtifactManager {

    @Autowired
    private DatabaseDao dbDao;

    @Autowired
    private FileDao fileDao;

    public Artifact create(String internPath, byte[] content) throws Exception {

        Artifact artifact = new JavaWar(internPath, "/");
        artifact = dbDao.create(artifact);

        fileDao.create(internPath, content);

        return artifact;
    }

    public Artifact get(UUID id) {
        return dbDao.get(id);
    }

    public Artifact[] getAll() {
        return new Artifact[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean delete(UUID id) throws Exception {
//        dbDao.delete(id);
        return false;
    }
}

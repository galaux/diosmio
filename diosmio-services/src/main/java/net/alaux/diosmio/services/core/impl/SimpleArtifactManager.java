package net.alaux.diosmio.services.core.impl;

import java.rmi.RemoteException;
import java.util.List;

import net.alaux.diosmio.services.core.ArtifactManager;
import net.alaux.diosmio.services.dao.db.impl.ArtifactDao;
import net.alaux.diosmio.services.dao.file.FileDao;
import net.alaux.diosmio.services.entity.Artifact;
import net.alaux.utils.AppMessages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: miguel Date: 7/26/12
 */
public class SimpleArtifactManager implements ArtifactManager {

    @Autowired
    private ArtifactDao artifactDao;

    @Autowired
    private FileDao fileDao;

    @Autowired
    private AppMessages appMessages;

    public static final String FILE_SEPARATOR = System
	    .getProperty("file.separator");

    public Log logger = LogFactory.getLog(SimpleArtifactManager.class);

    @Override
    public Artifact create(String name, byte[] content) throws RemoteException {

	logger.info("create()");

	/*
	 * TODO some sort of transaction: if
	 * "fileDao.create(artifact, content);" fails then remove the Artifact
	 * from the artifactDao too!
	 */
	Artifact artifact = new Artifact(name, FILE_SEPARATOR);
	artifactDao.create(artifact);
	fileDao.create(artifact, content);

	return artifact;
    }

    @Override
    public Artifact get(Long id) throws RemoteException {
	logger.info("get()");
	return artifactDao.get(id);
    }

    @Override
    public List<Artifact> getAll() throws RemoteException {
	logger.info("getAll()");
	return artifactDao.getAll();
    }

    @Override
    public void delete(Artifact artifact) throws RemoteException {
	logger.info("delete()");
	fileDao.delete(artifact);
	artifactDao.delete(artifact);
    }

    @Override
    public void delete(Long id) throws RemoteException {
	logger.info("delete()");
	Artifact artifact = artifactDao.get(id);
	fileDao.delete(artifact);
	artifactDao.delete(artifact);
    }
}

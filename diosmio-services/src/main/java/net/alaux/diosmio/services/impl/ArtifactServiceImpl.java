package net.alaux.diosmio.services.impl;

import java.util.ArrayList;
import java.util.List;

import net.alaux.diosmio.com.entity.Artifact;
import net.alaux.diosmio.com.service.ArtifactService;
import net.alaux.diosmio.com.utils.AppMessages;
import net.alaux.diosmio.services.dao.ArtifactDao;
import net.alaux.diosmio.services.file.ArtifactFileAo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: miguel Date: 7/26/12
 */
public class ArtifactServiceImpl implements ArtifactService {

    @Autowired
    private ArtifactDao artifactDao;

    @Autowired
    private ArtifactFileAo artifactFileAo;

    @Autowired
    private AppMessages appMessages;

    public static final String FILE_SEPARATOR = System
	    .getProperty("file.separator");

    public Log logger = LogFactory.getLog(ArtifactServiceImpl.class);

    @Override
    public Artifact create(String name, byte[] content) {

	logger.info("create()");

	/*
	 * TODO some sort of transaction: if
	 * "fileDao.create(artifact, content);" fails then remove the Artifact
	 * from the artifactDao too!
	 */
	Artifact artifact = new Artifact();
	artifact.setName(name);
	artifactDao.create(artifact);
	artifactFileAo.create(artifact, content);

	return artifact;
    }

    @Override
    public Artifact create(Artifact artifact) {
	logger.info("create()");

	/*
	 * TODO some sort of transaction: if
	 * "fileDao.create(artifact, content);" fails then remove the Artifact
	 * from the artifactDao too!
	 */
	artifactDao.create(artifact);
	// TODO
	// fileDao.create(artifact, content);

	return artifact;
    }

    @Override
    public Artifact get(Long id) {
	logger.info("get()");
	return artifactDao.get(id);
    }

    @Override
    public List<Artifact> getAll() {
	logger.info("getAll()");
	return artifactDao.getAll();
    }

    @Override
    public void delete(Artifact artifact) {
	logger.info("delete(Artifact(" + artifact.getId() + "))");
	// TODO use boolean return of this method
	artifactFileAo.delete(artifact);
	artifactDao.delete(artifact);
    }

    @Override
    public void delete(Long id) {
	logger.info("delete(" + id + ")");
	Artifact artifact = artifactDao.get(id);
	artifactFileAo.delete(artifact);
	artifactDao.delete(artifact);
    }

    @Override
    public void update(Artifact artifact) {
	logger.info("update()");
	artifactDao.update(artifact);
    }

    @Override
    public List<Long> delete(List<Long> ids) {
	logger.info("delete(" + ids + ")");
	List<Long> deletedIds = new ArrayList<Long>();

	// FIXME is it possible to fail here?
	for (Long id : ids) {
	    logger.info("\tdelete(" + id + ")");
	    artifactDao.delete(id);
	    logger.info("done");
	    deletedIds.add(id);
	}
	return deletedIds;
    }
}

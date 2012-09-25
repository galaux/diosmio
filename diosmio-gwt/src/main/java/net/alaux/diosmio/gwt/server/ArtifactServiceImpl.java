package net.alaux.diosmio.gwt.server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import net.alaux.diosmio.com.entity.Artifact;
import net.alaux.diosmio.com.service.ArtifactManager;
import net.alaux.diosmio.gwt.client.ArtifactService;
import net.alaux.diosmio.gwt.shared.ArtifactDto;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ArtifactServiceImpl extends SpringGwtServlet implements
	ArtifactService {

    public Log logger = LogFactory.getLog(ArtifactServiceImpl.class);

    @Autowired
    ArtifactManager artifactManager;

    @Override
    public ArtifactDto addArtifact(ArtifactDto dto) {
	try {
	    return createDto(artifactManager.create(createEntity(dto)));
	} catch (RemoteException e) {
	    e.printStackTrace();
	    return null;
	}
    }

    @Override
    public ArtifactDto getArtifact(Long id) {
	try {
	    return createDto(artifactManager.get(id));
	} catch (RemoteException e) {
	    e.printStackTrace();
	    return null;
	}
    }

    @Override
    public void deleteArtifact(Long id) {
	logger.info("deleteArtifact(" + id + ")");
	try {
	    artifactManager.delete(id);
	} catch (RemoteException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public ArtifactDto updateArtifact(ArtifactDto artifact) {
	try {
	    return createDto(artifactManager.update(createEntity(artifact)));
	} catch (RemoteException e) {
	    e.printStackTrace();
	    return null;
	}
    }

    @Override
    public List<Long> deleteArtifacts(List<Long> ids) {
	logger.info("deleteArtifacts(" + ids + ")");
	try {
	    return artifactManager.delete(ids);
	} catch (RemoteException e) {
	    e.printStackTrace();
	    return null;
	}
    }

    @Override
    public List<ArtifactDto> getAllArtifacts() {
	logger.info("getAllArtifacts()");
	logger.info("ArtifactManager: " + artifactManager);
	List<ArtifactDto> dtos = new ArrayList<ArtifactDto>();
	List<Artifact> entities;
	try {
	    entities = artifactManager.getAll();

	    for (Artifact entity : entities) {
		dtos.add(createDto(entity));
	    }
	} catch (RemoteException e) {
	    e.printStackTrace();
	}
	return dtos;
    }

    // *******************************************************
    // TODO put these as static in a utility package?
    private Artifact createEntity(ArtifactDto artifactDto) {
	Artifact artifact = new Artifact();
	artifact.setId(artifactDto.getId());
	artifact.setName(artifactDto.getName());
	return artifact;
    }

    private ArtifactDto createDto(Artifact artifact) {
	ArtifactDto artifactDto = new ArtifactDto();
	artifactDto.setId(artifact.getId());
	artifactDto.setName(artifact.getName());
	return artifactDto;
    }
}

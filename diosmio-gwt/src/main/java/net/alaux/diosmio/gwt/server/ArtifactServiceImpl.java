package net.alaux.diosmio.gwt.server;

import java.util.ArrayList;
import java.util.List;

import net.alaux.diosmio.gwt.client.ArtifactService;
import net.alaux.diosmio.gwt.shared.ArtifactDto;
import net.alaux.diosmio.services.core.ArtifactManager;
import net.alaux.diosmio.services.entity.Artifact;

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
	return createDto(artifactManager.create(createEntity(dto)));
    }

    @Override
    public ArtifactDto getArtifact(Long id) {
	return createDto(artifactManager.get(id));
    }

    @Override
    public void deleteArtifact(Long id) {
	logger.info("deleteArtifact(" + id + ")");
	artifactManager.delete(id);
    }

    @Override
    public ArtifactDto updateArtifact(ArtifactDto artifact) {
	return createDto(artifactManager.update(createEntity(artifact)));
    }

    @Override
    public List<Long> deleteArtifacts(List<Long> ids) {
	logger.info("deleteArtifacts(" + ids + ")");
	return artifactManager.delete(ids);
    }

    @Override
    public List<ArtifactDto> getAllArtifacts() {
	logger.info("getAllArtifacts()");
	logger.info("ArtifactManager: " + artifactManager);
	List<ArtifactDto> dtos = new ArrayList<ArtifactDto>();
	List<Artifact> entities = artifactManager.getAll();
	for (Artifact entity : entities) {
	    dtos.add(createDto(entity));
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

package net.alaux.diosmio.services.core;

import net.alaux.diosmio.services.entity.Artifact;

import java.util.List;

public interface ArtifactManager {

    public boolean getStatus();

    Artifact create(String internPath, byte[] content) throws Exception;

    Artifact get(Long id);

    List<Artifact> getAll();

    void delete(Artifact artifact) throws Exception;
}

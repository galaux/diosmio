package net.alaux.diosmio.services.core;

import net.alaux.diosmio.services.entity.Artifact;

import java.util.List;

public interface ArtifactManager {

    public Artifact create(String name, byte[] content);

    Artifact get(Long id);

    List<Artifact> getAll();

    public void delete(Artifact artifact);
}

package net.alaux.diosmio.services.core;

import net.alaux.diosmio.services.entity.Artifact;
import net.alaux.utils.AppException;

import java.io.IOException;
import java.util.List;

public interface ArtifactManager {

    public boolean getStatus();

    public Artifact create(String internPath, byte[] content) throws AppException, IOException;

    Artifact get(Long id);

    List<Artifact> getAll();

    public void delete(Artifact artifact) throws AppException;
}

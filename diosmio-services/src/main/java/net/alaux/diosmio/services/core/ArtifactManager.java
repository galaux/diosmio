package net.alaux.diosmio.services.core;

import net.alaux.diosmio.services.entity.Artifact;
import net.alaux.utils.AppException;

import java.io.IOException;
import java.util.List;

public interface ArtifactManager {

    public boolean getStatus();

    /**
     *
     * @param name name of the file
     * @param content
     * @return
     * @throws AppException
     * @throws IOException
     */
    public Artifact create(String name, byte[] content) throws AppException, IOException;

    Artifact get(Long id);

    List<Artifact> getAll();

    public void delete(Artifact artifact) throws AppException;
}

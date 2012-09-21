package net.alaux.diosmio.services.core;

import java.util.List;

import net.alaux.diosmio.services.entity.Artifact;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net>
 */
public interface ArtifactManager {

    public Artifact create(String name, byte[] content);

    public Artifact create(Artifact artifact);

    public Artifact get(Long id);

    public List<Artifact> getAll();

    public void delete(Artifact artifact);

    public void delete(Long id);

    public List<Long> delete(List<Long> ids);

    public Artifact update(Artifact artifact);
}

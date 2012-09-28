package net.alaux.diosmio.services.dao;

import java.util.List;

import net.alaux.diosmio.com.entity.Artifact;

public interface ArtifactDao {

    public void create(Artifact artifact);

    public Artifact get(Long id);

    public List<Artifact> getAll();

    public void update(Artifact artifact);

    public void delete(Artifact artifact);

    public void delete(Long id);
}

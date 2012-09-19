package net.alaux.diosmio.services.dao.db;

import java.util.List;

import net.alaux.diosmio.services.entity.Artifact;

public interface DatabaseDao {

    public void create(Artifact artifact);

    public Artifact get(Long id);

    public List<Artifact> getAll();

    public Artifact update(Artifact artifact);

    public void delete(Artifact artifact);
}

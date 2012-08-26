package net.alaux.diosmio.services.dao.db;

import net.alaux.diosmio.services.entity.Artifact;

import java.util.List;

public interface DatabaseDao {

    public void create(Artifact artifact);

    public Artifact get(Long id);

    public List<Artifact> getAll();

    public Artifact update(Artifact artifact);

    public void delete(Artifact artifact);
}

package net.alaux.diosmio.core.persistence.dao.db;

import net.alaux.diosmio.core.entity.Artifact;

import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/15/12
 * Time: 6:54 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DatabaseDao {

    public boolean getStatus();

    public void create(Artifact artifact);

    public Artifact get(Long id);

    public List<Artifact> getAll();

    public Artifact update(Artifact artifact);

    public void delete(Artifact artifact);
}

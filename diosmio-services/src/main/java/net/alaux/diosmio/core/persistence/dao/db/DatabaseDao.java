package net.alaux.diosmio.core.persistence.dao.db;

import net.alaux.diosmio.core.entity.Artifact;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/15/12
 * Time: 6:54 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DatabaseDao {

    public Artifact create(Artifact artifact);

    public Artifact get(UUID id);

    public Artifact update(Artifact artifact);

    public boolean delete(UUID id);
}

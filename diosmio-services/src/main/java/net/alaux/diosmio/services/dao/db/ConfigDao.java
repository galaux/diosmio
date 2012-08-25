package net.alaux.diosmio.services.dao.db;

import net.alaux.diosmio.services.entity.Configuration;

/**
 * User: miguel
 * Date: 8/11/12
 */
public interface ConfigDao {

    public boolean getStatus();

    public void create(Configuration);

    public Configuration read(Long id);

    public void update(Configuration configuration);

    public void delete(Configuration configuration);
}

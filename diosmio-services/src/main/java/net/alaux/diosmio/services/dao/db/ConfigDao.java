package net.alaux.diosmio.services.dao.db;

import net.alaux.diosmio.services.entity.Configuration;
import net.alaux.diosmio.services.entity.impl.HostConfig;

import java.util.List;

/**
 * User: miguel
 * Date: 8/11/12
 */
public interface ConfigDao {

    public void create(HostConfig hostConfig);

    public HostConfig read(Long id);

    public List<Configuration>  readAll();

    public void update(HostConfig hostConfig);

    public void delete(HostConfig hostConfig);
}

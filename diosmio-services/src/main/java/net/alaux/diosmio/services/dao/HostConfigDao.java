package net.alaux.diosmio.services.dao;

import java.util.List;

import net.alaux.diosmio.com.entity.impl.HostConfig;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net> Date: 8/11/12
 */
public interface HostConfigDao {

    public void create(HostConfig hostConfig);

    public HostConfig get(Long id);

    public List<HostConfig> getAll();

    public void update(HostConfig hostConfig);

    public void delete(HostConfig hostConfig);

    public void delete(Long id);
}

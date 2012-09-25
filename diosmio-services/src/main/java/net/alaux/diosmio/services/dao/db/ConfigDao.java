package net.alaux.diosmio.services.dao.db;

import net.alaux.diosmio.com.entity.impl.HostConfig;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net>
 * Date: 8/11/12
 */
public interface ConfigDao extends Remote {

    public void create(HostConfig hostConfig) throws RemoteException;

    public HostConfig read(Long id) throws RemoteException;

    public List<HostConfig>  readAll() throws RemoteException;

    public void update(HostConfig hostConfig) throws RemoteException;

    public void delete(HostConfig hostConfig) throws RemoteException;
}

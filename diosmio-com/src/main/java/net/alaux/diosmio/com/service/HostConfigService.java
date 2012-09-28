package net.alaux.diosmio.com.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import net.alaux.diosmio.com.entity.impl.HostConfig;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net>
 */
public interface HostConfigService extends Remote {

    public void create(HostConfig hostConfig) throws RemoteException;

    public HostConfig get(Long id) throws RemoteException;

    public List<HostConfig> getAll() throws RemoteException;

    public void delete(Long id) throws RemoteException;

    public List<Long> delete(List<Long> ids) throws RemoteException;

    public void update(HostConfig hostConfig) throws RemoteException;
}

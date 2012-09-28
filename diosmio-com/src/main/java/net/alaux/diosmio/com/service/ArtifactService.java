package net.alaux.diosmio.com.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import net.alaux.diosmio.com.entity.Artifact;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net>
 */
public interface ArtifactService extends Remote {

    public Artifact create(Artifact artifact, byte[] content)
	    throws RemoteException;

    @Deprecated
    public Artifact create(Artifact artifact) throws RemoteException;

    public Artifact get(Long id) throws RemoteException;

    public List<Artifact> getAll() throws RemoteException;

    public void delete(Artifact artifact) throws RemoteException;

    public void delete(Long id) throws RemoteException;

    public List<Long> delete(List<Long> ids) throws RemoteException;

    public void update(Artifact artifact) throws RemoteException;
}

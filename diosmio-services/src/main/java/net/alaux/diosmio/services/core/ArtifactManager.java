package net.alaux.diosmio.services.core;

import net.alaux.diosmio.services.entity.Artifact;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net>
 */
public interface ArtifactManager extends Remote {

    public Artifact create(String name, byte[] content) throws RemoteException;

    public Artifact get(Long id) throws RemoteException;

    public List<Artifact> getAll() throws RemoteException;

    public void delete(Artifact artifact) throws RemoteException;
}

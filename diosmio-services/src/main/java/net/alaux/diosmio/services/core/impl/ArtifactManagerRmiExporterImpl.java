package net.alaux.diosmio.services.core.impl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import net.alaux.diosmio.services.core.ArtifactManager;
import net.alaux.diosmio.services.entity.Artifact;

import org.springframework.beans.factory.annotation.Autowired;

/*
 * This class is only because RMI needs methods to throw RemoteException
 * which is irrelevant if ArtifactManagerImpl methods is invoked without RMI
 * (ie in presentation layer)
 */
/*
 * TODO make this class accept DTO only as input from CLI
 */
public class ArtifactManagerRmiExporterImpl implements Remote {

    @Autowired
    ArtifactManager artifactManager;

    public Artifact create(String name, byte[] content) throws RemoteException {
	return artifactManager.create(name, content);
    }

    public Artifact create(Artifact artifact) throws RemoteException {
	return artifactManager.create(artifact);
    }

    public Artifact get(Long id) throws RemoteException {
	return artifactManager.get(id);
    }

    public List<Artifact> getAll() throws RemoteException {
	return artifactManager.getAll();
    }

    public void delete(Artifact artifact) throws RemoteException {
	artifactManager.delete(artifact);
    }

    public void delete(Long id) throws RemoteException {
	artifactManager.delete(id);
    }
}

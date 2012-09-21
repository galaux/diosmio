package net.alaux.diosmio.services.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import net.alaux.diosmio.services.core.ArtifactManager;
import net.alaux.diosmio.services.dao.db.ConfigDao;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net> Date: 8/27/12
 * @deprecated
 */
@Deprecated
public interface RmiServicePublisher extends Remote {

    public ArtifactManager getArtifactManager() throws RemoteException;

    public ConfigDao getConfigDao() throws RemoteException;
}

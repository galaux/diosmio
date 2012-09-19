package net.alaux.diosmio.services.rmi;

import net.alaux.diosmio.services.core.ArtifactManager;
import net.alaux.diosmio.services.dao.db.ConfigDao;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net>
 *         Date: 8/27/12
 */
public interface RmiServicePublisher extends Remote {

    public ArtifactManager getArtifactManager() throws RemoteException;

    public ConfigDao getConfigDao() throws RemoteException;
}

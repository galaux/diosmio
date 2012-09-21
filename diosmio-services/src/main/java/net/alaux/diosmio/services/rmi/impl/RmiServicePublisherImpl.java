package net.alaux.diosmio.services.rmi.impl;

import java.rmi.RemoteException;

import net.alaux.diosmio.services.core.ArtifactManager;
import net.alaux.diosmio.services.dao.db.ConfigDao;
import net.alaux.diosmio.services.rmi.RmiServicePublisher;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net> Date: 8/27/12
 * @deprecated
 */
@Deprecated
public class RmiServicePublisherImpl implements RmiServicePublisher {

    @Autowired
    private ArtifactManager artifactManager;

    @Autowired
    private ConfigDao configDao;

    @Override
    public ArtifactManager getArtifactManager() throws RemoteException {
	return artifactManager;
    }

    @Override
    public ConfigDao getConfigDao() throws RemoteException {
	return configDao;
    }
}

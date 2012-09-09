package net.alaux.diosmio.services.rmi.impl;

import net.alaux.diosmio.services.core.ArtifactManager;
import net.alaux.diosmio.services.dao.db.ConfigDao;
import net.alaux.diosmio.services.rmi.RmiServicePublisher;
import org.springframework.beans.factory.annotation.Autowired;

import java.rmi.RemoteException;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net>
 *         Date: 8/27/12
 */
public class RmiServicePublisherImpl implements RmiServicePublisher {

    @Autowired
    private ArtifactManager artifactManager;

    @Autowired
    private ConfigDao configDao;

    public ArtifactManager getArtifactManager() throws RemoteException {
        return artifactManager;
    }

    public ConfigDao getConfigDao() throws RemoteException {
        return configDao;
    }
}

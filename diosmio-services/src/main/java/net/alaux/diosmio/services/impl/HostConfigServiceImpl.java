package net.alaux.diosmio.services.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import net.alaux.diosmio.com.entity.impl.HostConfig;
import net.alaux.diosmio.com.service.HostConfigService;
import net.alaux.diosmio.services.dao.HostConfigDao;

import org.springframework.beans.factory.annotation.Autowired;

public class HostConfigServiceImpl implements HostConfigService {

    @Autowired
    HostConfigDao hostConfigDao;

    @Override
    public void create(HostConfig hostConfig) throws RemoteException {
	hostConfigDao.create(hostConfig);
    }

    @Override
    public HostConfig get(Long id) throws RemoteException {
	return hostConfigDao.get(id);
    }

    @Override
    public List<HostConfig> getAll() throws RemoteException {
	return hostConfigDao.getAll();
    }

    @Override
    public void delete(Long id) throws RemoteException {
	hostConfigDao.delete(id);
    }

    @Override
    public List<Long> delete(List<Long> ids) throws RemoteException {
	List<Long> deletedIds = new ArrayList<Long>();
	for (Long id : ids) {
	    hostConfigDao.delete(id);
	    deletedIds.add(id);
	}
	return deletedIds;
    }

    @Override
    public void update(HostConfig hostConfig) throws RemoteException {
	hostConfigDao.update(hostConfig);
    }
}

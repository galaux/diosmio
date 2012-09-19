package net.alaux.diosmio.services.dao.db.impl;

import java.rmi.RemoteException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.alaux.diosmio.services.dao.db.ConfigDao;
import net.alaux.diosmio.services.entity.impl.HostConfig;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net> Date: 8/11/12
 */
public class SimpleConfigDao implements ConfigDao {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private JpaTransactionManager transactionManager;

    public Log logger = LogFactory.getLog(SimpleConfigDao.class);

    @Override
    public void create(HostConfig hostConfig) throws RemoteException {
	logger.info("create(HostConfig)");

	TransactionStatus status = transactionManager
		.getTransaction(new DefaultTransactionDefinition());

	em.persist(hostConfig);
	transactionManager.commit(status);
    }

    @Override
    public HostConfig read(Long id) throws RemoteException {
	logger.info("read(HostConfig, " + id + ")");

	HostConfig result = em.find(HostConfig.class, id);
	return result;
    }

    @Override
    public List<HostConfig> readAll() throws RemoteException {
	logger.info("getAll()");

	// FIXME Do we need a transaction here?
	List<HostConfig> result = em
		.createQuery("SELECT hc from HostConfig hc").getResultList();
	// TODO em.createNativeQuery("")

	return result;
    }

    @Override
    public void update(HostConfig hostConfig) throws RemoteException {
	logger.info("update(HostConfig) - NOT IMPLEMENTED");

	TransactionStatus status = transactionManager
		.getTransaction(new DefaultTransactionDefinition());
	em.persist(hostConfig);
	transactionManager.commit(status);

	// TODO make it return the hostconfig???
	// return hostConfig;
    }

    @Override
    public void delete(HostConfig hostConfig) throws RemoteException {
	logger.info("delete()");

	TransactionStatus status = transactionManager
		.getTransaction(new DefaultTransactionDefinition());
	em.remove(hostConfig);
	transactionManager.commit(status);
    }
}

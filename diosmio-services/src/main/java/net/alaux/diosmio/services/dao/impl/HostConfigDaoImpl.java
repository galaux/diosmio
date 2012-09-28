package net.alaux.diosmio.services.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import net.alaux.diosmio.com.entity.impl.HostConfig;
import net.alaux.diosmio.services.dao.HostConfigDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net> Date: 8/11/12
 */
public class HostConfigDaoImpl implements HostConfigDao {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private JpaTransactionManager transactionManager;

    public Log logger = LogFactory.getLog(HostConfigDaoImpl.class);

    @Override
    public void create(HostConfig hostConfig) {
	logger.info("create(HostConfig)");
	TransactionStatus status = transactionManager
		.getTransaction(new DefaultTransactionDefinition());

	em.persist(hostConfig);
	transactionManager.commit(status);
    }

    @Override
    public HostConfig get(Long id) {
	logger.info("read(HostConfig, " + id + ")");
	HostConfig result = em.find(HostConfig.class, id);
	return result;
    }

    @Override
    public List<HostConfig> getAll() {
	logger.info("getAll()");
	TypedQuery<HostConfig> query = em.createNamedQuery(
		HostConfig.Q_FIND_ALL, HostConfig.class);
	return query.getResultList();
    }

    @Override
    public void update(HostConfig hostConfig) {
	logger.info("update(HostConfig)");
	TransactionStatus status = transactionManager
		.getTransaction(new DefaultTransactionDefinition());
	em.persist(hostConfig);
	transactionManager.commit(status);
    }

    @Override
    public void delete(HostConfig hostConfig) {
	logger.info("delete()");
	TransactionStatus status = transactionManager
		.getTransaction(new DefaultTransactionDefinition());
	em.remove(hostConfig);
	transactionManager.commit(status);
    }

    @Override
    public void delete(Long id) {
	logger.info("delete(" + id + ")");
	TransactionStatus status = transactionManager
		.getTransaction(new DefaultTransactionDefinition());
	em.createNamedQuery(HostConfig.Q_DELETE_BY_ID, HostConfig.class)
		.setParameter("id", id).executeUpdate();
	transactionManager.commit(status);
    }
}

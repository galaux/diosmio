package net.alaux.diosmio.services.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.alaux.diosmio.com.entity.Artifact;
import net.alaux.diosmio.services.dao.ArtifactDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author miguel Date: 7/30/12 Time: 10:06 PM
 */
public class ArtifactDaoImpl implements ArtifactDao {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private JpaTransactionManager transactionManager;

    public Log logger = LogFactory.getLog(ArtifactDao.class);

    @Override
    public void create(Artifact artifact) {

	logger.info("create()");

	TransactionStatus status = transactionManager
		.getTransaction(new DefaultTransactionDefinition());

	em.persist(artifact);
	transactionManager.commit(status);
    }

    @Override
    public Artifact get(Long id) {

	logger.info("get(" + id + ")");

	Artifact result = em.find(Artifact.class, id);
	return result;
    }

    @Override
    public List<Artifact> getAll() {
	logger.info("getAll()");
	return em.createQuery(Artifact.Q_FIND_ALL, Artifact.class)
		.getResultList();
    }

    @Override
    public void update(Artifact artifact) {

	logger.info("update()");

	TransactionStatus status = transactionManager
		.getTransaction(new DefaultTransactionDefinition());
	em.persist(em.merge(artifact));
	transactionManager.commit(status);
    }

    @Override
    public void delete(Artifact artifact) {
	logger.info("delete(Artifact(" + artifact.getId() + "))");

	TransactionStatus status = transactionManager
		.getTransaction(new DefaultTransactionDefinition());
	em.remove(em.merge(artifact));
	transactionManager.commit(status);
    }

    @Override
    public void delete(Long id) {
	logger.info("delete(" + id + ")");

	TransactionStatus status = transactionManager
		.getTransaction(new DefaultTransactionDefinition());

	em.createNamedQuery(Artifact.Q_DELETE_BY_ID, Artifact.class)
		.setParameter("id", id).executeUpdate();

	transactionManager.commit(status);
    }
}

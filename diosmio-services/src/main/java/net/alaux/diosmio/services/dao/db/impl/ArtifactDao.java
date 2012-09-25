package net.alaux.diosmio.services.dao.db.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import net.alaux.diosmio.com.entity.Artifact;
import net.alaux.diosmio.services.dao.db.DatabaseDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author miguel Date: 7/30/12 Time: 10:06 PM
 */
public class ArtifactDao implements DatabaseDao {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private JpaTransactionManager transactionManager;

    public static final String Q_FIND_ALL = "SELECT a FROM Artifact a";
    public static final String Q_DELETE_BY_ID = "DELETE FROM Artifact a WHERE a.id = :id";

    public Log logger = LogFactory.getLog(ArtifactDao.class);

    @Override
    public void create(Artifact artifact) {

	logger.info("create()");

	TransactionStatus status = transactionManager
		.getTransaction(new DefaultTransactionDefinition());

	// try {
	em.persist(artifact);
	transactionManager.commit(status);
	// } catch (Exception e) {
	// transactionManager.rollback(status);
	// // TODO add nice message
	// throw new RuntimeException(e);
	// }
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

	TypedQuery<Artifact> query = em.createQuery(Q_FIND_ALL, Artifact.class);
	List<Artifact> result = query.getResultList();

	return result;
    }

    @Override
    public Artifact update(Artifact artifact) {

	logger.info("update()");

	TransactionStatus status = transactionManager
		.getTransaction(new DefaultTransactionDefinition());
	em.persist(em.merge(artifact));
	transactionManager.commit(status);

	return artifact;
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
	// TODO Put as named query in Artifact

	TypedQuery<Artifact> query = em.createQuery(Q_DELETE_BY_ID,
		Artifact.class);
	int deletedCount = query.setParameter("id", id).executeUpdate();
	System.out.println("-" + deletedCount + "-");

	transactionManager.commit(status);
    }
}

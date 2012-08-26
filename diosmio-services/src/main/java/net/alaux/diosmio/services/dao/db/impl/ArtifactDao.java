package net.alaux.diosmio.services.dao.db.impl;

import net.alaux.diosmio.services.dao.db.DatabaseDao;
import net.alaux.diosmio.services.entity.Artifact;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/30/12
 * Time: 10:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArtifactDao implements DatabaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Log logger = LogFactory.getLog(ArtifactDao.class);

    /**
     *
     * @param artifact
     */
    public void create(Artifact artifact) {

        logger.info("create()");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(artifact);
        session.getTransaction().commit();
        session.close();
    }

    /**
     *
     * @param id
     * @return
     */
    public Artifact get(Long id) {

        logger.info("get(" + id + ")");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Artifact result = (Artifact) session.get(Artifact.class, id);
        session.getTransaction().commit();
        session.close();

        return result;
    }

    /**
     *
     * @return
     */
    public List<Artifact> getAll() {

        logger.info("getAll()");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from Artifact").list();
        session.getTransaction().commit();
        session.close();

        return result;
    }

    /**
     *
     * @param artifact
     * @return
     */
    public Artifact update(Artifact artifact) {

        logger.info("update()");

//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.get(Artifact.class, artifact.)
//        session.getTransaction().commit();
//        session.close();

        return null;
    }

    /**
     *
     * @param artifact
     * @return
     */
    public void delete(Artifact artifact) {

        logger.info("delete()");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(artifact);
        session.getTransaction().commit();
        session.close();
    }


}

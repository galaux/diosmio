package net.alaux.diosmio.core.persistence.dao.db.impl;

import net.alaux.diosmio.core.entity.Artifact;
import net.alaux.diosmio.core.persistence.dao.db.DatabaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PreDestroy;
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

    public Logger logger = LoggerFactory.getLogger(ArtifactDao.class);

    @PreDestroy
    protected void tearDown() throws Exception {
        if ( sessionFactory != null ) {
            sessionFactory.close();
        }
    }

    public boolean getStatus() {
        return sessionFactory != null;
    }

    /**
     *
     * @param artifact
     */
    public void create(Artifact artifact) {

        System.out.println("create()");

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

        System.out.println("get()");

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

        System.out.println("getAll()");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery( "from Artifact" ).list();
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

        System.out.println("update()");

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
    public boolean delete(Artifact artifact) {

        System.out.println("delete()");

        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }


}

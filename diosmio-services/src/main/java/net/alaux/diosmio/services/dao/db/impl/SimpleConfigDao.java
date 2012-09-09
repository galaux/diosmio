package net.alaux.diosmio.services.dao.db.impl;

import net.alaux.diosmio.services.dao.db.ConfigDao;
import net.alaux.diosmio.services.entity.impl.HostConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.rmi.RemoteException;
import java.util.List;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net>
 * Date: 8/11/12
 */
public class SimpleConfigDao implements ConfigDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Log logger = LogFactory.getLog(SimpleConfigDao.class);

    public void create(HostConfig hostConfig) throws RemoteException {
        logger.info("create(HostConfig)");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(hostConfig);
        session.getTransaction().commit();
        session.close();
    }

    public HostConfig read(Long id) throws RemoteException {
        logger.info("read(HostConfig, " + id + ")");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        HostConfig hostConfig = (HostConfig) session.get(HostConfig.class, id);
        session.getTransaction().commit();
        session.close();

        return hostConfig;
    }

    public List<HostConfig> readAll() throws RemoteException {
        logger.info("getAll()");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List result = session.createQuery("from HostConfig").list();
        session.getTransaction().commit();
        session.close();

        return result;
    }

    public void update(HostConfig hostConfig) throws RemoteException {
        logger.info("update(HostConfig) - NOT IMPLEMENTED");
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void delete(HostConfig hostConfig) throws RemoteException {
        logger.info("delete() - NOT IMPLEMENTED");
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

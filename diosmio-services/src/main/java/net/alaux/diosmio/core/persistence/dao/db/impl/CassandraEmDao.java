package net.alaux.diosmio.core.persistence.dao.db.impl;

import me.prettyprint.cassandra.service.template.ColumnFamilyTemplate;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.ddl.KeyspaceDefinition;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hom.EntityManagerImpl;
import net.alaux.diosmio.core.entity.Artifact;
import net.alaux.diosmio.core.persistence.dao.db.DatabaseDao;
import net.alaux.diosmio.core.entity.impl.JavaWar;
import net.alaux.diosmio.server.common.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/15/12
 * Time: 6:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class CassandraEmDao implements DatabaseDao {

    @Autowired
    AppProperties appProps;

    private Cluster cluster;
    private KeyspaceDefinition keyspaceDef;
    private Cluster appCluster;
    private ColumnFamilyTemplate<String, String> template;
    private Keyspace ksp;

    private EntityManagerImpl em = null;

    private final Logger logger = LoggerFactory.getLogger(CassandraEmDao.class);


    @PostConstruct
    public void init() {
        Cluster cluster = HFactory.getOrCreateCluster(appProps.cassandraClusterName,
                appProps.cassandraClusterHost + ":" + appProps.cassandraClusterPort);
        Keyspace keyspace = HFactory.createKeyspace(appProps.cassandraClusterKeyspace, cluster);

        if (em == null) {
            em = new EntityManagerImpl(keyspace, "net.alaux.diosmio.core.database.entity");
        }
    }

    @PreDestroy
    public void preDestroy() {
        close();
    }

    public Artifact create(Artifact artifact) {
        return em.persist(artifact);
    }

    // Will need to pass a Class to specify what Type of object we expect
    public Artifact get(UUID id) {
        return em.find(JavaWar.class, id);
    }

    public Artifact update(Artifact artifact) {
        return em.persist(artifact);
    }

    public boolean delete(UUID id) {
        return false;
    }

    public void close() {
        cluster.getConnectionManager().shutdown();
    }
}

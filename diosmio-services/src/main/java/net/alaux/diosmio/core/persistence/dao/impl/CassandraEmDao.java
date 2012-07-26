package net.alaux.diosmio.core.persistence.dao.impl;

import me.prettyprint.cassandra.service.template.ColumnFamilyTemplate;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.ddl.KeyspaceDefinition;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hom.EntityManagerImpl;
import net.alaux.diosmio.core.persistence.dao.PersistenceDao;
import net.alaux.diosmio.core.persistence.entity.Artifact;
import net.alaux.diosmio.server.common.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/15/12
 * Time: 6:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class CassandraEmDao implements PersistenceDao {

    @Autowired
    AppProperties appProps;

    private Cluster cluster;
    private KeyspaceDefinition keyspaceDef;
    private Cluster appCluster;
    private ColumnFamilyTemplate<String, String> template;
    private Keyspace ksp;

    private EntityManagerImpl em = null;

    public CassandraEmDao() {

////        Cluster cluster = HFactory.getOrCreateCluster("TestPool", "192.168.0.1:9160");
//        Cluster cluster = HFactory.getOrCreateCluster(appProps.CASSANDRA_CLUSTER_NAME,
//                appProps.CASSANDRA_CLUSTER_HOST + ":" + appProps.CASSANDRA_CLUSTER_PORT);
//        Keyspace keyspace = HFactory.createKeyspace(appProps.CASSANDRA_KEYSPACE, cluster);

//        try {

//        if (em == null) {
//            em = new EntityManagerImpl(keyspace, "net.alaux.diosmio.core.persistence.entity");
//        }

//            Artifact pojo1 = new Artifact();
//            pojo1.setId(UUID.randomUUID());
//            pojo1.setLongProp1(123L);
//
//            em.persist(pojo1);
//
//            // do some stuff
//
//            Artifact pojo2 = em.find(Artifact.class, pojo1.getId());
//
//            // do some more stuff
//
//            System.out.println("Id = " + pojo2.getId());
//            System.out.println("LonProp1 = " + pojo2.getLongProp1());
//        } finally {
//            cluster.getConnectionManager().shutdown();
//        }
    }

    public void create(Artifact artifact) {
        artifact.setId(UUID.randomUUID());
        em.persist(artifact);
    }

//    public void read() {
//
//    }
//
//    public void update() {
//
//    }
//
//    public void delete() {
//
//    }

    public void close() {
        cluster.getConnectionManager().shutdown();
    }
}

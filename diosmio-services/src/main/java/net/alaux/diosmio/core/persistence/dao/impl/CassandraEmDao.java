package net.alaux.diosmio.core.persistence.dao.impl;

import me.prettyprint.cassandra.serializers.StringSerializer;
import me.prettyprint.cassandra.service.ThriftKsDef;
import me.prettyprint.cassandra.service.template.ColumnFamilyTemplate;
import me.prettyprint.cassandra.service.template.ColumnFamilyUpdater;
import me.prettyprint.cassandra.service.template.ThriftColumnFamilyTemplate;
import me.prettyprint.hector.api.Cluster;
import me.prettyprint.hector.api.Keyspace;
import me.prettyprint.hector.api.ddl.ColumnFamilyDefinition;
import me.prettyprint.hector.api.ddl.ComparatorType;
import me.prettyprint.hector.api.ddl.KeyspaceDefinition;
import me.prettyprint.hector.api.exceptions.HectorException;
import me.prettyprint.hector.api.factory.HFactory;
import me.prettyprint.hom.EntityManagerImpl;
import net.alaux.diosmio.core.persistence.dao.PersistenceDao;
import net.alaux.diosmio.core.persistence.entity.Artifact;

import java.util.Arrays;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/15/12
 * Time: 6:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class CassandraEmDao implements PersistenceDao {

    public static final String CASSANDRA_CLUSTER_NAME = "DiosMio-cluster";
    public static final String CASSANDRA_CLUSTER_HOST = "localhost";
    public static final String CASSANDRA_CLUSTER_PORT = "9160";
    public static final String CASSANDRA_KEYSPACE = "DiosMioKeyspace";
    public static final int CASSANDRA_REPLICATION_FACTOR = 1;
    private Cluster cluster;
    private KeyspaceDefinition keyspaceDef;
    private Cluster appCluster;
    private ColumnFamilyTemplate<String, String> template;
    private Keyspace ksp;

    public CassandraEmDao() {

        Cluster cluster = HFactory.getOrCreateCluster("TestPool", "192.168.0.1:9160");
        Keyspace keyspace = HFactory.createKeyspace("DiosMioKeyspace", cluster);

        try {
            EntityManagerImpl em = new EntityManagerImpl(keyspace, "net.alaux");

            Artifact pojo1 = new Artifact();
            pojo1.setId(UUID.randomUUID());
            pojo1.setLongProp1(123L);

            em.persist(pojo1);

            // do some stuff

            Artifact pojo2 = em.find(Artifact.class, pojo1.getId());

            // do some more stuff

            System.out.println("Id = " + pojo2.getId());
            System.out.println("LonProp1 = " + pojo2.getLongProp1());
        } finally {
            cluster.getConnectionManager().shutdown();
        }
    }
}

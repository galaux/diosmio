package net.alaux.diosmio.services.dao.impl;

import net.alaux.diosmio.services.dao.ArtifactDao;

/**
 * Created with IntelliJ IDEA. User: miguel Date: 7/15/12 Time: 6:55 PM To
 * change this template use File | Settings | File Templates.
 */
public abstract class CassandraEmDao implements ArtifactDao {

    // @Value("${server.persistence.cassandra.cluster.name}")
    // public String cassandraClusterName;
    //
    // @Value("${server.persistence.cassandra.cluster.host}")
    // public String cassandraClusterHost;
    //
    // @Value("${server.persistence.cassandra.cluster.port}")
    // public String cassandraClusterPort;
    //
    // @Value("${server.persistence.cassandra.keyspace}")
    // public String cassandraClusterKeyspace;
    //
    // @Value("${server.persistence.cassandra.replication_factor}")
    // public String cassandraClusterReplicationFactor;
    //
    // private Cluster cluster;
    // private KeyspaceDefinition keyspaceDef;
    // private Cluster appCluster;
    // private ColumnFamilyTemplate<String, String> template;
    // private Keyspace keyspace;
    //
    // private EntityManagerImpl em = null;
    //
    // private final Logger logger =
    // LoggerFactory.getLogger(CassandraEmDao.class);
    //
    //
    // @PostConstruct
    // public void init() {
    // logger.info("Initializing CassandraEmDao");
    // cluster = HFactory.getOrCreateCluster(appProps.cassandraClusterName,
    // appProps.cassandraClusterHost + ":" + appProps.cassandraClusterPort);
    // keyspace = HFactory.createKeyspace(appProps.cassandraClusterKeyspace,
    // cluster);
    //
    // if (em == null) {
    // em = new EntityManagerImpl(keyspace,
    // "net.alaux.diosmio.core.database.entity");
    // }
    // }
    //
    // @PreDestroy
    // public void preDestroy() {
    // logger.info("Destroying CassandraEmDao");
    // close();
    // }
    //
    // public boolean getStatus() {
    // return (cluster != null) && (keyspace != null) && (em != null);
    // }
    //
    // public Artifact create(Artifact artifact) {
    // logger.info("create()");
    // return em.persist(artifact);
    // }
    //
    // // Will need to pass a Class to specify what Type of object we expect
    // public Artifact get(UUID id) {
    // logger.info("get()");
    // return em.find(JavaWar.class, id);
    // }
    //
    // public Artifact update(Artifact artifact) {
    // logger.info("update()");
    // return em.persist(artifact);
    // }
    //
    // public boolean delete(UUID id) {
    // logger.info("delete()");
    // return false;
    // }
    //
    // public void close() {
    // logger.info("closing connection");
    // cluster.getConnectionManager().shutdown();
    // }
}

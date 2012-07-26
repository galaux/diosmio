package net.alaux.diosmio.server.common;

import org.springframework.beans.factory.annotation.Value;

public class AppProperties {

    // Application properties
    @Value("${server.store.directory.path}")
    public String storageDirPath;

    // Persistence
    @Value("${server.persistence.cassandra.cluster.name}")
    public String cassandraClusterName;

    @Value("${server.persistence.cassandra.cluster.host}")
    public static String cassandraClusterHost;

    @Value("${server.persistence.cassandra.cluster.port}")
    public static String cassandraClusterPort;

    @Value("${server.persistence.cassandra.keyspace}")
    public static String cassandraClusterKeyspace;

    @Value("${server.persistence.cassandra.replication_factor}")
    public static String cassandraClusterReplicationFactor;


    public static final String FILE_SEPARATOR   = System.getProperty("file.separator");
}

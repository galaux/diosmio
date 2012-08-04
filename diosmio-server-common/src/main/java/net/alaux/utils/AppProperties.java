package net.alaux.utils;

import org.springframework.beans.factory.annotation.Value;

public class AppProperties {

    // Application properties
    @Value("${server.store.directory.path}")
    public String storageDirPath;

    // Persistence
    @Value("${server.persistence.cassandra.cluster.name}")
    public String cassandraClusterName;

    @Value("${server.persistence.cassandra.cluster.host}")
    public String cassandraClusterHost;

    @Value("${server.persistence.cassandra.cluster.port}")
    public String cassandraClusterPort;

    @Value("${server.persistence.cassandra.keyspace}")
    public String cassandraClusterKeyspace;

    @Value("${server.persistence.cassandra.replication_factor}")
    public String cassandraClusterReplicationFactor;


    public static final String FILE_SEPARATOR   = System.getProperty("file.separator");


//    // Exceptions
//    @Value("${file_already_exists}")
//    public String errFileAlreadyExists;
//
//    @Value("${storage_dir_not_accessible}")
//    public String errStorageDirNotAccessible;

}

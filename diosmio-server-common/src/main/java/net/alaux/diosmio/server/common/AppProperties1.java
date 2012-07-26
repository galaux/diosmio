package net.alaux.diosmio.server.common;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/18/12
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */
public enum AppProperties1 {

    // Server
    STORAGE_DIR_PATH,

    // Persistence
    // Cassandra
    CASSANDRA_CLUSTER_NAME, CASSANDRA_CLUSTER_HOST, CASSANDRA_CLUSTER_PORT, CASSANDRA_KEYSPACE, CASSANDRA_REPLICATION_FACTOR;


    public static final String FILE_SEPARATOR   = System.getProperty("file.separator");

    @Autowired
    public Properties serviceProperties;

    @Override
    public String toString() {
        System.out.println("--> " + serviceProperties);
        return serviceProperties.getProperty(this.name());
    }

    public int toInt() {
        return Integer.valueOf(serviceProperties.getProperty(this.name()));
    }
}

package net.alaux.diosmio.server.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/18/12
 * Time: 11:28 PM
 * To change this template use File | Settings | File Templates.
 */
public final class AppProperties2 {

    @Autowired
    private static Properties serviceProperties;

    @Autowired
    private static Properties defaultServiceProperties;

    private static Properties properties = (serviceProperties != null) ? serviceProperties : defaultServiceProperties;


    private static String confFilepath;

    private static final Logger logger                  = LoggerFactory.getLogger(AppProperties2.class);

    // Application properties
    public static String STORAGE_DIR_PATH               = properties.getProperty("server.store.directory.path");

    public static String CASSANDRA_CLUSTER_NAME         = properties.getProperty("server.persistence.cassandra.cluster.name");
    public static String CASSANDRA_CLUSTER_HOST         = properties.getProperty("server.persistence.cassandra.cluster.host");
    public static String CASSANDRA_CLUSTER_PORT         = properties.getProperty("server.persistence.cassandra.cluster.port");
    public static String CASSANDRA_KEYSPACE             = properties.getProperty("server.persistence.cassandra.keyspace");
    public static String CASSANDRA_REPLICATION_FACTOR   = properties.getProperty("server.persistence.cassandra.replication_factor");

    public static final String FILE_SEPARATOR           = System.getProperty("file.separator");


//    public AppConstants(Properties properties, Properties defaultProperties) throws Exception {
//
//        this.properties = properties;

//        this.properties = new Properties();
//        try {
//            properties.load(new FileInputStream(confFilepath));
//            this.confFilepath = confFilepath;
//            logger.info("Using application config file '" + confFilepath + "'" );
//
//        } catch (IOException e) {
//            logger.error("error.no_regular_config");
//            try {
//                properties.load(this.getClass().getResourceAsStream(defaultConfFilepath));
//                this.confFilepath = defaultConfFilepath;
//                logger.info("Falling back to default conf file '" + defaultConfFilepath + "'");
//
//            } catch (IOException e2) {
//                throw new Exception("error.no_default_config");
//            }
//        }
//    }
}

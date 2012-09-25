package net.alaux.diosmio.ui.cli.jmx;

import net.alaux.diosmio.com.service.ArtifactManager;
import net.alaux.diosmio.services.dao.db.ConfigDao;
import net.alaux.diosmio.ui.cli.Main;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 8/6/12
 * Time: 12:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class JmxConnection {

    private static final String BEAN_ARTIFACT_MANAGER_NAME= "artifactManager";
    private static final String BEAN_CONFIG_DAO_NAME= "configDao";

    private String jmxUrl;
    protected String domainName;

    JMXServiceURL url;
    JMXConnector jmxc;
    MBeanServerConnection mbsc;

    public JmxConnection(String jmxUrl, String domainName) throws IOException {

        Main.logger.info("JmxConnection.JmxConnection()");

        this.jmxUrl = jmxUrl;
        this.domainName = domainName;

        url = new JMXServiceURL(jmxUrl);
        jmxc = JMXConnectorFactory.connect(url, null);
        mbsc = jmxc.getMBeanServerConnection();
    }

    public void closeJmxConnection() throws IOException {
        jmxc.close();
    }

    public  <T> T getServiceBean(Class<T> clazz) throws InstanceNotFoundException, MalformedObjectNameException {

        ObjectName mbeanName = null;
        // TODO put BEAN_ARTIFACT_MANAGER_NAME in ArtifactManager and call general value
        if (clazz == ArtifactManager.class) {
            mbeanName = new ObjectName(this.domainName + ":name=" + BEAN_ARTIFACT_MANAGER_NAME);

        } else if (clazz == ConfigDao.class) {
            mbeanName = new ObjectName(this.domainName + ":name=" + BEAN_CONFIG_DAO_NAME);
        }

        T mbean =  JMX.newMBeanProxy(mbsc, mbeanName, clazz, true);
//        ClientListener listener = new ClientListener();
//        mbsc.addNotificationListener(mbeanName, listener, null, null);

        return mbean;
    }
}

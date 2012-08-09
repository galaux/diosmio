package net.alaux.diosmio.ui.cli.jmxcli;

import net.alaux.diosmio.services.core.ArtifactManager;

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
public class DiosMioJmxConnection {

    private static final String BEAN_ARTIFACT_MANAGER_NAME= "artifactManager";

    private String jmxUrl;
    protected String domainName;

    JMXServiceURL url;
    JMXConnector jmxc;
    MBeanServerConnection mbsc;

    public DiosMioJmxConnection(String jmxUrl, String domainName) throws IOException {

        this.jmxUrl = jmxUrl;
        this.domainName = domainName;

        url = new JMXServiceURL(jmxUrl);
        jmxc = JMXConnectorFactory.connect(url, null);
        mbsc = jmxc.getMBeanServerConnection();
    }

    public void closeJmxConnection() throws IOException {
        jmxc.close();
    }

    public  <T> T getServiceBean(Class<T> clazz) throws IOException, InstanceNotFoundException, MalformedObjectNameException {

        T mbean = null;
        // TODO put BEAN_ARTIFACT_MANAGER_NAME in ArtifactManager and call general value
        if (clazz == ArtifactManager.class) {
            ObjectName mbeanName = new ObjectName(this.domainName + ":name=" + BEAN_ARTIFACT_MANAGER_NAME);
            mbean =  JMX.newMBeanProxy(mbsc, mbeanName, clazz, true);
            ClientListener listener = new ClientListener();
            mbsc.addNotificationListener(mbeanName, listener, null, null);
        }
        return mbean;
    }
}

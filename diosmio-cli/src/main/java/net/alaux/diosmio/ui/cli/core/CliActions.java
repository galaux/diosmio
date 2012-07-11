package net.alaux.diosmio.ui.cli.core;

import net.alaux.diosmio.core.services.IArtifactManager;
import net.alaux.diosmio.ui.cli.ClientListener;
import sun.org.mozilla.javascript.ast.ReturnStatement;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/7/12
 * Time: 7:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class CliActions {

    private static final String JMX_URL = "service:jmx:rmi:///jndi/rmi://:8090/jmxrmi";
    static final String DM_DOMAIN_NAME="net.alaux.diosmio";

    private static final String BEAN_ARTIFACT_MANAGER_NAME= "artifactManager";

    JMXServiceURL url;
    JMXConnector jmxc;
    MBeanServerConnection mbsc;

    void initJmxConnection() throws IOException {
        url = new JMXServiceURL(JMX_URL);
        jmxc = JMXConnectorFactory.connect(url, null);
        mbsc = jmxc.getMBeanServerConnection();
    }

    void closeJmxConnection() throws IOException {
        jmxc.close();
    }

    public  <T> T getServiceBean(Class<T> clazz) throws IOException, InstanceNotFoundException, MalformedObjectNameException {

        T mbean = null;
        if (clazz == IArtifactManager.class) {
            ObjectName mbeanName = new ObjectName(DM_DOMAIN_NAME + ":name=" + BEAN_ARTIFACT_MANAGER_NAME);
            mbean =  JMX.newMBeanProxy(mbsc, mbeanName, clazz, true);
            ClientListener listener = new ClientListener();
            mbsc.addNotificationListener(mbeanName, listener, null, null);
        }
        return mbean;
    }
}

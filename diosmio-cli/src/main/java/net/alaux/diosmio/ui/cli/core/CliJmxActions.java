package net.alaux.diosmio.ui.cli.core;

import net.alaux.diosmio.services.core.ArtifactManager;
import net.alaux.diosmio.ui.cli.ClientListener;
import net.alaux.diosmio.ui.cli.DiosMioCli;

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
public class CliJmxActions {

    private static final String JMX_URL = DiosMioCli.getProperty("cli.rmi.url");
    static final String DM_DOMAIN_NAME = DiosMioCli.getProperty("common.domain_name");

    private static final String BEAN_ARTIFACT_MANAGER_NAME= "artifactManager";

    JMXServiceURL url;
    JMXConnector jmxc;
    MBeanServerConnection mbsc;

    public CliJmxActions() throws IOException {
        url = new JMXServiceURL(JMX_URL);
        jmxc = JMXConnectorFactory.connect(url, null);
        mbsc = jmxc.getMBeanServerConnection();
    }

    public void closeJmxConnection() throws IOException {
        jmxc.close();
    }

    public  <T> T getServiceBean(Class<T> clazz) throws IOException, InstanceNotFoundException, MalformedObjectNameException {

        T mbean = null;
        if (clazz == ArtifactManager.class) {
            ObjectName mbeanName = new ObjectName(DM_DOMAIN_NAME + ":name=" + BEAN_ARTIFACT_MANAGER_NAME);
            mbean =  JMX.newMBeanProxy(mbsc, mbeanName, clazz, true);
            ClientListener listener = new ClientListener();
            mbsc.addNotificationListener(mbeanName, listener, null, null);
        }
        return mbean;
    }
}

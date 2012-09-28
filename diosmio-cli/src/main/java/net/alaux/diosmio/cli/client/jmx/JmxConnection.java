package net.alaux.diosmio.cli.client.jmx;

import java.io.IOException;

import javax.management.InstanceNotFoundException;
import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import net.alaux.diosmio.cli.Main;
import net.alaux.diosmio.com.service.ArtifactService;
import net.alaux.diosmio.com.service.HostConfigService;

/**
 * Created with IntelliJ IDEA. User: miguel Date: 8/6/12 Time: 12:05 AM To
 * change this template use File | Settings | File Templates.
 */
public class JmxConnection {

    private static final String BEAN_ARTIFACT_MANAGER_NAME = "artifactManager";
    private static final String BEAN_CONFIG_DAO_NAME = "configDao";

    protected String domainName;

    JMXServiceURL url;
    JMXConnector jmxc;
    MBeanServerConnection mbsc;

    public JmxConnection(String jmxUrl, String domainName) throws IOException {

	Main.logger.info("JmxConnection.JmxConnection()");

	this.domainName = domainName;

	url = new JMXServiceURL(jmxUrl);
	jmxc = JMXConnectorFactory.connect(url, null);
	mbsc = jmxc.getMBeanServerConnection();
    }

    public void closeJmxConnection() throws IOException {
	jmxc.close();
    }

    public <T> T getServiceBean(Class<T> clazz)
	    throws InstanceNotFoundException, MalformedObjectNameException {

	ObjectName mbeanName = null;
	if (clazz == ArtifactService.class) {
	    mbeanName = new ObjectName(this.domainName + ":name="
		    + BEAN_ARTIFACT_MANAGER_NAME);

	} else if (clazz == HostConfigService.class) {
	    mbeanName = new ObjectName(this.domainName + ":name="
		    + BEAN_CONFIG_DAO_NAME);
	}

	T mbean = JMX.newMBeanProxy(mbsc, mbeanName, clazz, true);

	return mbean;
    }
}

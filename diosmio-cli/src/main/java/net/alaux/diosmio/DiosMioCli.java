package net.alaux.diosmio;

import net.alaux.diosmio.core.services.IArtifactManager;

import javax.annotation.Resource;
import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.File;


/**
 * Hello world!
 * 
 */
public class DiosMioCli {

	private static final String JMX_URL = "service:jmx:rmi:///jndi/rmi://:8090/jmxrmi";
    private static final String DISMIO_BEAN_NAME = "net.alaux.diosmio:name=fileSystemArtifactManager";

//	@Resource(name = "sayHello")
//	SaySomething saySomething;

	public static void main(String[] args) throws Exception {
		System.out.println("Main...");

		JMXServiceURL url = new JMXServiceURL(JMX_URL);
		JMXConnector jmxc = JMXConnectorFactory.connect(url, null);

		MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

		// System.out.println("\nDomains:");
		// String domains[] = mbsc.getDomains();
		// Arrays.sort(domains);
		// for (String domain : domains) {
		// System.out.println("\tDomain = " + domain);
		// }

		// System.out.println("\nMBeanServer default domain = "
		// + mbsc.getDefaultDomain());

		// System.out.println("\nMBean count = " + mbsc.getMBeanCount());
//		System.out.println("\nQuery MBeanServer MBeans:");
//		Set<ObjectName> names = new TreeSet<ObjectName>(mbsc.queryNames(null,
//				null));
//
//		for (ObjectName name : names) {
//			System.out.println("\tObjectName = " + name);
//		}


//        ObjectName mbeanName = new ObjectName("com.example:type=Hello");
        ObjectName mbeanName = new ObjectName(DISMIO_BEAN_NAME);
        IArtifactManager mbeanProxy
                = JMX.newMBeanProxy(mbsc, mbeanName, IArtifactManager.class, true);

        ClientListener listener = new ClientListener();
        System.out.println("\nAdd notification listener...");
		mbsc.addNotificationListener(mbeanName, listener, null, null);

//        System.out.println("\nCacheSize = " + mbeanProxy.getCacheSize());

//		mbeanProxy.setCacheSize(150);
        File[] artifactList = mbeanProxy.listArtifacts();

        System.out.println("\nGot " + artifactList.length + " files.");


		jmxc.close();
	}
}

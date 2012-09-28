package net.alaux.diosmio.cli.client.jmx;

import java.io.IOException;

import javax.management.InstanceNotFoundException;
import javax.management.MalformedObjectNameException;

import net.alaux.diosmio.cli.Main;
import net.alaux.diosmio.cli.client.CliClient;
import net.alaux.diosmio.com.service.ArtifactService;
import net.alaux.diosmio.com.service.HostConfigService;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net>
 */
public class CliJmxClient extends CliClient {

    private final String url;
    private final String domain;

    private JmxConnection jmxConnection;

    public CliJmxClient(String url, String domain) {
	this.url = url;
	this.domain = domain;
    }

    private JmxConnection getJmxConnection() {

	if (jmxConnection == null) {
	    try {
		jmxConnection = new JmxConnection(url, domain);
	    } catch (IOException e) {
		throw new RuntimeException(
			Main.bundle.getString("error.server_connection"), e);
	    }
	}

	return jmxConnection;
    }

    @Override
    public ArtifactService getArtifactService() {

	if (artifactService == null) {
	    try {
		artifactService = getJmxConnection().getServiceBean(
			ArtifactService.class);
	    } catch (MalformedObjectNameException e) {
		throw new RuntimeException(
			Main.bundle.getString("error.server_connection"), e);
	    } catch (InstanceNotFoundException e) {
		throw new RuntimeException(
			Main.bundle.getString("error.server_connection"), e);
	    }
	}
	return artifactService;
    }

    @Override
    public HostConfigService getHostConfigService() {
	if (hostConfigService == null) {
	    try {
		hostConfigService = getJmxConnection().getServiceBean(
			HostConfigService.class);
	    } catch (InstanceNotFoundException e) {
		throw new RuntimeException(
			Main.bundle.getString("error.server_connection"), e);
	    } catch (MalformedObjectNameException e) {
		throw new RuntimeException(
			Main.bundle.getString("error.server_connection"), e);
	    }
	}
	return hostConfigService;
    }

    @Override
    public void close() {
	if (jmxConnection != null) {
	    try {
		jmxConnection.closeJmxConnection();
	    } catch (IOException e) {
		throw new RuntimeException(
			Main.bundle.getString("error.server_connection"), e);
	    }
	}
    }
}

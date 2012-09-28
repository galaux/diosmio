package net.alaux.diosmio.cli.client.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import net.alaux.diosmio.cli.Main;
import net.alaux.diosmio.cli.client.CliClient;
import net.alaux.diosmio.com.service.ArtifactService;
import net.alaux.diosmio.com.service.HostConfigService;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net> Date: 8/27/12
 */
public class CliRmiClient extends CliClient {

    private final int artifactServiceRmiPort;
    private final int hostConfigServiceRmiPort;

    private ArtifactService artifactService;
    private HostConfigService hostConfigService;

    public CliRmiClient(int artifactServiceRmiPort, int hostConfigServiceRmiPort) {
	this.artifactServiceRmiPort = artifactServiceRmiPort;
	this.hostConfigServiceRmiPort = hostConfigServiceRmiPort;
    }

    @Override
    public ArtifactService getArtifactService() {

	if (artifactService == null) {
	    try {
		Registry registry = LocateRegistry
			.getRegistry(artifactServiceRmiPort);
		artifactService = (ArtifactService) registry
			.lookup("artifactService");
	    } catch (RemoteException e) {
		throw new RuntimeException(
			Main.bundle.getString("error.server_connection"), e);

	    } catch (NotBoundException e) {
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
		Registry registry = LocateRegistry
			.getRegistry(hostConfigServiceRmiPort);
		hostConfigService = (HostConfigService) registry
			.lookup("hostConfigService");
	    } catch (RemoteException e) {
		throw new RuntimeException(
			Main.bundle.getString("error.server_connection"), e);

	    } catch (NotBoundException e) {
		throw new RuntimeException(
			Main.bundle.getString("error.server_connection"), e);
	    }
	}

	return hostConfigService;
    }

    @Override
    public void close() {
	// Nothing to do
    }
}

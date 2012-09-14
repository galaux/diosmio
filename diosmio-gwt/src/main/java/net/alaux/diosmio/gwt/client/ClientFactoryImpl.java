package net.alaux.diosmio.gwt.client;

import net.alaux.diosmio.gwt.client.view.MainAppView;
import net.alaux.diosmio.gwt.client.view.MainAppViewImpl;
import net.alaux.diosmio.gwt.client.view.artifact.ArtifactView;
import net.alaux.diosmio.gwt.client.view.artifact.ArtifactViewImpl;
import net.alaux.diosmio.gwt.client.view.artifact.ArtifactsList;
import net.alaux.diosmio.gwt.client.view.artifact.ArtifactsListImpl;
import net.alaux.diosmio.gwt.shared.Artifact;

import com.google.gwt.event.shared.HandlerManager;

public class ClientFactoryImpl implements ClientFactory {

    // private final EventBus eventBus = new SimpleEventBus();
    private final HandlerManager eventBus = new HandlerManager(null);

    private ArtifactView artifactView;

    private ArtifactsList<Artifact> artifactsList;

    private MainAppView mainAppView;

    @Override
    public HandlerManager getEventBus() {
	return eventBus;
    }

    @Override
    public ArtifactView getArtifactView() {
	if (artifactView == null) {
	    artifactView = new ArtifactViewImpl();
	}
	return artifactView;
    }

    @Override
    public ArtifactsList<Artifact> getArtifactsList() {
	if (artifactsList == null) {
	    artifactsList = new ArtifactsListImpl<Artifact>();
	}
	return artifactsList;
    }

    @Override
    public MainAppView getMainAppView() {
	if (mainAppView == null) {
	    mainAppView = new MainAppViewImpl();
	}
	return mainAppView;
    }

}

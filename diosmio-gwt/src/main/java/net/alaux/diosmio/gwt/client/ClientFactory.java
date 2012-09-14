package net.alaux.diosmio.gwt.client;

import net.alaux.diosmio.gwt.client.view.MainAppView;
import net.alaux.diosmio.gwt.client.view.artifact.ArtifactView;
import net.alaux.diosmio.gwt.client.view.artifact.ArtifactsList;
import net.alaux.diosmio.gwt.shared.Artifact;

import com.google.gwt.event.shared.HandlerManager;

public interface ClientFactory {

    // TODO change for a EventBus getEventBus();
    HandlerManager getEventBus();

    // PlaceController getPlaceController();

    ArtifactView getArtifactView();

    // TODO is it OK to pass an Artifact here?
    ArtifactsList<Artifact> getArtifactsList();

    MainAppView getMainAppView();
}

package net.alaux.diosmio.gwt.client.event.artifact;

import net.alaux.diosmio.gwt.shared.Artifact;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class ArtifactUpdatedEvent extends
	GwtEvent<ArtifactUpdatedEvent.ArtifactUpdatedHandler> {

    public static Type<ArtifactUpdatedHandler> TYPE = new Type<ArtifactUpdatedHandler>();

    private final Artifact artifact;

    public Artifact getArtifact() {
	return artifact;
    }

    public interface ArtifactUpdatedHandler extends EventHandler {
	void onArtifactUpdated(ArtifactUpdatedEvent event);
    }

    public ArtifactUpdatedEvent(Artifact artifact) {
	this.artifact = artifact;
    }

    @Override
    protected void dispatch(ArtifactUpdatedHandler handler) {
	handler.onArtifactUpdated(this);
    }

    @Override
    public Type<ArtifactUpdatedHandler> getAssociatedType() {
	return TYPE;
    }

    public static Type<ArtifactUpdatedHandler> getType() {
	return TYPE;
    }
}

package net.alaux.diosmio.gwt.client.event;

import net.alaux.diosmio.gwt.shared.Artifact;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class ArtifactAddedEvent extends
	GwtEvent<ArtifactAddedEvent.ArtifactAddedHandler> {

    public static Type<ArtifactAddedHandler> TYPE = new Type<ArtifactAddedHandler>();

    public interface ArtifactAddedHandler extends EventHandler {
	void onArtifactAdded(ArtifactAddedEvent event);
    }

    private final Artifact artifact;

    public Artifact getArtifact() {
	return artifact;
    }

    public ArtifactAddedEvent(Artifact artifact) {
	this.artifact = artifact;
    }

    @Override
    protected void dispatch(ArtifactAddedHandler handler) {
	handler.onArtifactAdded(this);
    }

    @Override
    public Type<ArtifactAddedHandler> getAssociatedType() {
	return TYPE;
    }

    public static Type<ArtifactAddedHandler> getType() {
	return TYPE;
    }
}

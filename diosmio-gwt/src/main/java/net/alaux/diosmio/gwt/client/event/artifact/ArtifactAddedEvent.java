package net.alaux.diosmio.gwt.client.event.artifact;

import net.alaux.diosmio.gwt.shared.ArtifactDto;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class ArtifactAddedEvent extends
	GwtEvent<ArtifactAddedEvent.ArtifactAddedHandler> {

    public static Type<ArtifactAddedHandler> TYPE = new Type<ArtifactAddedHandler>();

    public interface ArtifactAddedHandler extends EventHandler {
	void onArtifactAdded(ArtifactAddedEvent event);
    }

    private final ArtifactDto artifact;

    public ArtifactDto getArtifact() {
	return artifact;
    }

    public ArtifactAddedEvent(ArtifactDto artifact) {
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

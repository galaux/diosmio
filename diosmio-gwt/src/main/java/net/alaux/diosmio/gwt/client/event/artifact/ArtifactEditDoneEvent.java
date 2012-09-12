package net.alaux.diosmio.gwt.client.event.artifact;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class ArtifactEditDoneEvent extends
	GwtEvent<ArtifactEditDoneEvent.ArtifactEditDoneHandler> {

    public static Type<ArtifactEditDoneHandler> TYPE = new Type<ArtifactEditDoneHandler>();

    public interface ArtifactEditDoneHandler extends EventHandler {
	void onArtifactEditDone(ArtifactEditDoneEvent event);
    }

    public ArtifactEditDoneEvent() {
    }

    @Override
    protected void dispatch(ArtifactEditDoneHandler handler) {
	handler.onArtifactEditDone(this);
    }

    @Override
    public Type<ArtifactEditDoneHandler> getAssociatedType() {
	return TYPE;
    }

    public static Type<ArtifactEditDoneHandler> getType() {
	return TYPE;
    }
}

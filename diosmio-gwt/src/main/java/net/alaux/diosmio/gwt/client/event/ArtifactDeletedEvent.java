package net.alaux.diosmio.gwt.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class ArtifactDeletedEvent extends
	GwtEvent<ArtifactDeletedEvent.ArtifactDeletedHandler> {

    public static Type<ArtifactDeletedHandler> TYPE = new Type<ArtifactDeletedHandler>();

    public interface ArtifactDeletedHandler extends EventHandler {
	void onArtifactDeleted(ArtifactDeletedEvent event);
    }

    public ArtifactDeletedEvent() {
    }

    @Override
    protected void dispatch(ArtifactDeletedHandler handler) {
	handler.onArtifactDeleted(this);
    }

    @Override
    public Type<ArtifactDeletedHandler> getAssociatedType() {
	return TYPE;
    }

    public static Type<ArtifactDeletedHandler> getType() {
	return TYPE;
    }
}

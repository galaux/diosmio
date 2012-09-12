package net.alaux.diosmio.gwt.client.event.artifact;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class AddArtifactEvent extends
	GwtEvent<AddArtifactEvent.AddArtifactHandler> {

    public static Type<AddArtifactHandler> TYPE = new Type<AddArtifactHandler>();

    public interface AddArtifactHandler extends EventHandler {
	void onAddArtifact(AddArtifactEvent event);
    }

    public AddArtifactEvent() {
    }

    @Override
    protected void dispatch(AddArtifactHandler handler) {
	handler.onAddArtifact(this);
    }

    @Override
    public Type<AddArtifactHandler> getAssociatedType() {
	return TYPE;
    }

    public static Type<AddArtifactHandler> getType() {
	return TYPE;
    }
}

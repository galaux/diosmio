package net.alaux.diosmio.gwt.client.event.artifact;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class EditArtifactEvent extends
	GwtEvent<EditArtifactEvent.EditArtifactHandler> {

    public static Type<EditArtifactHandler> TYPE = new Type<EditArtifactHandler>();

    public interface EditArtifactHandler extends EventHandler {
	void onEditArtifact(EditArtifactEvent event);
    }

    private final Long selectedArtifactId;

    public Long getSelectedArtifactId() {
	return selectedArtifactId;
    }

    public EditArtifactEvent(Long selectedArtifactId) {
	this.selectedArtifactId = selectedArtifactId;
    }

    @Override
    protected void dispatch(EditArtifactHandler handler) {
	handler.onEditArtifact(this);
    }

    @Override
    public Type<EditArtifactHandler> getAssociatedType() {
	return TYPE;
    }

    public static Type<EditArtifactHandler> getType() {
	return TYPE;
    }
}

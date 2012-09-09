package net.alaux.diosmio.gwt.client.presenter;

import net.alaux.diosmio.gwt.client.ArtifactServiceAsync;
import net.alaux.diosmio.gwt.client.event.ArtifactDeletedEvent;
import net.alaux.diosmio.gwt.client.event.ArtifactEditDoneEvent;
import net.alaux.diosmio.gwt.client.event.ArtifactUpdatedEvent;
import net.alaux.diosmio.gwt.shared.Artifact;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

// Will need to implement the use of a Bus
public class ArtifactPresenter implements Presenter {

    public interface Display {

	HasValue<String> getId();

	HasValue<String> getName();

	HasClickHandlers getDeleteButton();

	HasClickHandlers getSaveButton();

	HasClickHandlers getCloseButton();

	Widget asWidget();
    }

    private final Display display;
    private final ArtifactServiceAsync service;
    private final HandlerManager eventBus;

    @Override
    public void go(final HasWidgets container) {
	container.clear();
	container.add(display.asWidget());
    }

    private Artifact artifact;

    /**
     * Used to show an empty Artifact Panel
     * 
     * @param service
     * @param display
     */
    public ArtifactPresenter(ArtifactServiceAsync service, Display display,
	    HandlerManager eventBusParam) {
	this.service = service;
	this.display = display;
	this.eventBus = eventBusParam;
	this.artifact = new Artifact();
    }

    /**
     * Used to show a filled Artifact Panel
     * 
     * @param service
     * @param display
     * @param id
     */
    public ArtifactPresenter(ArtifactServiceAsync service, Display display,
	    Long id, HandlerManager eventBusParam) {

	this.service = service;
	this.display = display;
	this.eventBus = eventBusParam;

	service.getArtifact(id, new AsyncCallback<Artifact>() {

	    @Override
	    public void onSuccess(Artifact result) {
		artifact = result;
		ArtifactPresenter.this.display.getId().setValue(
			artifact.getId().toString());
		ArtifactPresenter.this.display.getName().setValue(
			artifact.getName());
	    }

	    @Override
	    public void onFailure(Throwable caught) {
		Window.alert("Error retrieving artifact");
	    }
	});
    }

    @UiHandler("deleteButton")
    void deleteButtonOnClick(ClickEvent e) {

	service.deleteArtifact(artifact.getId(), new AsyncCallback<Boolean>() {

	    @Override
	    public void onSuccess(Boolean result) {
		eventBus.fireEvent(new ArtifactDeletedEvent());
	    }

	    @Override
	    public void onFailure(Throwable caught) {
		Window.alert("Error while trying to delete artifact");
	    }
	});
    }

    @UiHandler("saveButton")
    void saveButtonOnClick(ClickEvent e) {

	artifact.setName(display.getName().getValue());

	service.updateArtifact(artifact, new AsyncCallback<Artifact>() {

	    @Override
	    public void onSuccess(Artifact result) {
		artifact = result;
		eventBus.fireEvent(new ArtifactUpdatedEvent(artifact));
		Window.alert("Artifact saved.");
	    }

	    @Override
	    public void onFailure(Throwable caught) {
		Window.alert("Error while trying to save artifact");
	    }
	});
    }

    @UiHandler("closeButton")
    void closeButtonOnClick(ClickEvent e) {
	eventBus.fireEvent(new ArtifactEditDoneEvent());
    }
}

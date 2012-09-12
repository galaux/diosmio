package net.alaux.diosmio.gwt.client.presenter.artifact;

import net.alaux.diosmio.gwt.client.ArtifactServiceAsync;
import net.alaux.diosmio.gwt.client.event.artifact.ArtifactDeletedEvent;
import net.alaux.diosmio.gwt.client.event.artifact.ArtifactEditDoneEvent;
import net.alaux.diosmio.gwt.client.event.artifact.ArtifactUpdatedEvent;
import net.alaux.diosmio.gwt.client.view.artifact.ArtifactView;
import net.alaux.diosmio.gwt.shared.Artifact;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class ArtifactPresenter implements ArtifactView.Presenter {

    /*
     * FIXME Does specifying that the Presenter has a pointer on ArtifactView
     * rather than on a generic Display break the MVP pattern???
     */
    private final ArtifactView view;
    private final ArtifactServiceAsync service;
    private final HandlerManager eventBus;

    private Artifact artifact;

    /**
     * Used to show an empty Artifact Panel
     * 
     * @param service
     * @param display
     */
    public ArtifactPresenter(ArtifactServiceAsync service, ArtifactView view,
	    HandlerManager eventBusParam) {
	this.service = service;
	this.view = view;
	this.eventBus = eventBusParam;

	this.artifact = new Artifact();

	view.setPresenter(this);
    }

    public ArtifactPresenter(ArtifactServiceAsync s, ArtifactView v,
	    HandlerManager b, Long id) {

	this.service = s;
	this.view = v;
	this.eventBus = b;

	this.artifact = new Artifact();

	view.setPresenter(this);

	retrieveArtifact(id);
    }

    private void retrieveArtifact(Long id) {

	service.getArtifact(id, new AsyncCallback<Artifact>() {

	    @Override
	    public void onSuccess(Artifact result) {
		view.setId(result.getId());
		view.setName(result.getName());
	    }

	    @Override
	    public void onFailure(Throwable caught) {
		Window.alert("Error retrieving artifact");
	    }
	});
    }

    @Override
    public void go(final HasWidgets container) {
	container.clear();
	container.add(view.asWidget());
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

    @UiHandler("closeButton")
    void closeButtonOnClick(ClickEvent e) {
	eventBus.fireEvent(new ArtifactEditDoneEvent());
    }

    @Override
    public void onSaveButtonClicked() {
	artifact.setName(view.getName());

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

    @Override
    public void onDeleteButtonClicked() {
	// TODO Auto-generated method stub
	Window.alert("TODO onDeleteButtonClicked");
    }

    @Override
    public void onCloseButtonClicked() {
	// TODO Auto-generated method stub
	Window.alert("TODO onCloseButtonClicked");
    }
}

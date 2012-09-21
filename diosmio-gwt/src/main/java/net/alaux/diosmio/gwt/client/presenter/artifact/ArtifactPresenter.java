package net.alaux.diosmio.gwt.client.presenter.artifact;

import net.alaux.diosmio.gwt.client.ArtifactServiceAsync;
import net.alaux.diosmio.gwt.client.event.artifact.ArtifactDeletedEvent;
import net.alaux.diosmio.gwt.client.event.artifact.ArtifactEditDoneEvent;
import net.alaux.diosmio.gwt.client.event.artifact.ArtifactUpdatedEvent;
import net.alaux.diosmio.gwt.client.view.artifact.ArtifactView;
import net.alaux.diosmio.gwt.shared.ArtifactDto;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class ArtifactPresenter implements ArtifactView.Presenter {

    /*
     * FIXME Does specifying that the Presenter has a pointer on ArtifactView
     * rather than on a generic Display break the MVP pattern???
     * 
     * Answer: no because the P has a pointer to the interface ArtifactView and
     * NOT to its GWT implementation ArtifactViewImpl !
     */
    private final ArtifactView view;
    private final ArtifactServiceAsync service;
    private final HandlerManager eventBus;

    private ArtifactDto artifact;

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

	this.artifact = new ArtifactDto();

	view.setPresenter(this);

	// Clear view
	view.setId(null);
	view.setName(null);
    }

    public ArtifactPresenter(ArtifactServiceAsync s, ArtifactView v,
	    HandlerManager b, Long id) {

	this.service = s;
	this.view = v;
	this.eventBus = b;

	view.setPresenter(this);

	retrieveArtifact(id);
    }

    private void retrieveArtifact(Long id) {

	service.getArtifact(id, new AsyncCallback<ArtifactDto>() {

	    @Override
	    public void onSuccess(ArtifactDto result) {
		artifact = result;
		view.setId(result.getId());
		view.setName(result.getName());
	    }

	    @Override
	    public void onFailure(Throwable caught) {
		Window.alert("Error retrieving artifact");
	    }
	});
    }

    // go method ********************************
    @Override
    public void go(final HasWidgets container) {
	container.clear();
	container.add(view.asWidget());
    }

    // Event handling ***************************
    @Override
    public void onSaveButtonClicked() {
	artifact.setName(view.getName());

	// New artifact
	if (artifact.getId() == null) {
	    service.addArtifact(artifact, new AsyncCallback<ArtifactDto>() {

		@Override
		public void onSuccess(ArtifactDto result) {
		    artifact = result;
		    eventBus.fireEvent(new ArtifactUpdatedEvent(artifact));
		    Window.alert("Artifact saved");
		}

		@Override
		public void onFailure(Throwable caught) {
		    Window.alert("Error while trying to save artifact");
		}
	    });
	} else {
	    service.updateArtifact(artifact, new AsyncCallback<ArtifactDto>() {

		@Override
		public void onSuccess(ArtifactDto result) {
		    artifact = result;
		    eventBus.fireEvent(new ArtifactUpdatedEvent(artifact));
		    Window.alert("Artifact saved");
		}

		@Override
		public void onFailure(Throwable caught) {
		    Window.alert("Error while trying to save artifact");
		}
	    });
	}
    }

    @Override
    public void onDeleteButtonClicked() {
	service.deleteArtifact(artifact.getId(), new AsyncCallback<Void>() {

	    @Override
	    public void onSuccess(Void result) {
		eventBus.fireEvent(new ArtifactDeletedEvent());
	    }

	    @Override
	    public void onFailure(Throwable caught) {
		Window.alert("Error while trying to delete artifact");
	    }
	});
    }

    @Override
    public void onCloseButtonClicked() {
	eventBus.fireEvent(new ArtifactEditDoneEvent());
    }
}

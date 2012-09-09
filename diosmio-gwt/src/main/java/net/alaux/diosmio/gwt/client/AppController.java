package net.alaux.diosmio.gwt.client;

import net.alaux.diosmio.gwt.client.event.ArtifactAddedEvent;
import net.alaux.diosmio.gwt.client.event.ArtifactAddedEvent.ArtifactAddedHandler;
import net.alaux.diosmio.gwt.client.event.ArtifactDeletedEvent;
import net.alaux.diosmio.gwt.client.event.ArtifactDeletedEvent.ArtifactDeletedHandler;
import net.alaux.diosmio.gwt.client.event.ArtifactEditDoneEvent;
import net.alaux.diosmio.gwt.client.event.ArtifactEditDoneEvent.ArtifactEditDoneHandler;
import net.alaux.diosmio.gwt.client.event.ArtifactUpdatedEvent;
import net.alaux.diosmio.gwt.client.event.ArtifactUpdatedEvent.ArtifactUpdatedHandler;
import net.alaux.diosmio.gwt.client.presenter.ArtifactPresenter;
import net.alaux.diosmio.gwt.client.presenter.Presenter;
import net.alaux.diosmio.gwt.client.view.ArtifactPanel;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String> {

    /**
     * RootPanel passed by EntryPoint
     */
    private HasWidgets container;
    private final ArtifactServiceAsync service;
    private final HandlerManager eventBus;

    public AppController(ArtifactServiceAsync service, HandlerManager eventBus) {
	this.service = service;
	this.eventBus = eventBus;

	eventBus.addHandler(ArtifactAddedEvent.TYPE,
		new ArtifactAddedHandler() {
		    @Override
		    public void onArtifactAdded(ArtifactAddedEvent event) {
			doOnArtifactAdded();
		    }
		});

	eventBus.addHandler(ArtifactDeletedEvent.TYPE,
		new ArtifactDeletedHandler() {
		    @Override
		    public void onArtifactDeleted(ArtifactDeletedEvent event) {
			doOnArtifactDeleted();
		    }
		});

	eventBus.addHandler(ArtifactEditDoneEvent.TYPE,
		new ArtifactEditDoneHandler() {
		    @Override
		    public void onArtifactEditDone(ArtifactEditDoneEvent event) {
			doOnArtifactEditDone();
		    }
		});

	eventBus.addHandler(ArtifactUpdatedEvent.TYPE,
		new ArtifactUpdatedHandler() {
		    @Override
		    public void onArtifactUpdated(ArtifactUpdatedEvent event) {
			doOnArtifactUpdated();
		    }
		});
    }

    private void doOnArtifactAdded() {
	// TODO let the Artifact List know about this new Artifact
    }

    private void doOnArtifactDeleted() {
	// TODO let the Artifact List know about this deleted Artifact
    }

    private void doOnArtifactEditDone() {
	// TODO Close Artifact Panel, open an other one
    }

    private void doOnArtifactUpdated() {
	// TODO let the Artifact List know about this Artifact change
    }

    /**
     * "HasWidgets container" = RootPanel passed by EntryPoint
     */
    @Override
    public void go(final HasWidgets container) {
	this.container = container;
	ArtifactPresenter artifactPresenter = new ArtifactPresenter(service,
		new ArtifactPanel(), 1L, eventBus);
	artifactPresenter.go(container);
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
	// TODO Auto-generated method stub

    }
}

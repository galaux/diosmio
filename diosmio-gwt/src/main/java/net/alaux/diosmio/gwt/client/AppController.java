package net.alaux.diosmio.gwt.client;

import java.util.List;

import net.alaux.diosmio.gwt.client.common.ArtifactsColumnDefinitionsFactory;
import net.alaux.diosmio.gwt.client.common.ColumnDefinition;
import net.alaux.diosmio.gwt.client.event.artifact.AddArtifactEvent;
import net.alaux.diosmio.gwt.client.event.artifact.AddArtifactEvent.AddArtifactHandler;
import net.alaux.diosmio.gwt.client.event.artifact.ArtifactAddedEvent;
import net.alaux.diosmio.gwt.client.event.artifact.ArtifactAddedEvent.ArtifactAddedHandler;
import net.alaux.diosmio.gwt.client.event.artifact.ArtifactDeletedEvent;
import net.alaux.diosmio.gwt.client.event.artifact.ArtifactDeletedEvent.ArtifactDeletedHandler;
import net.alaux.diosmio.gwt.client.event.artifact.ArtifactEditDoneEvent;
import net.alaux.diosmio.gwt.client.event.artifact.ArtifactEditDoneEvent.ArtifactEditDoneHandler;
import net.alaux.diosmio.gwt.client.event.artifact.ArtifactUpdatedEvent;
import net.alaux.diosmio.gwt.client.event.artifact.ArtifactUpdatedEvent.ArtifactUpdatedHandler;
import net.alaux.diosmio.gwt.client.event.artifact.EditArtifactEvent;
import net.alaux.diosmio.gwt.client.event.artifact.EditArtifactEvent.EditArtifactHandler;
import net.alaux.diosmio.gwt.client.presenter.PresenterOLD;
import net.alaux.diosmio.gwt.client.presenter.artifact.ArtifactPresenter;
import net.alaux.diosmio.gwt.client.presenter.artifact.ArtifactsListPresenter;
import net.alaux.diosmio.gwt.client.view.artifact.ArtifactViewImpl;
import net.alaux.diosmio.gwt.client.view.artifact.ArtifactsListImpl;
import net.alaux.diosmio.gwt.shared.Artifact;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements PresenterOLD, ValueChangeHandler<String> {

    /**
     * RootPanel passed by EntryPoint
     */
    private HasWidgets container;
    private final ArtifactServiceAsync service;
    private final HandlerManager eventBus;

    public AppController(ArtifactServiceAsync service, HandlerManager eventBus) {
	this.service = service;
	this.eventBus = eventBus;
	bind();
    }

    private void bind() {
	History.addValueChangeHandler(this);
	// Artifact
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

	// Artifacts list
	eventBus.addHandler(AddArtifactEvent.TYPE, new AddArtifactHandler() {
	    @Override
	    public void onAddArtifact(AddArtifactEvent event) {
		doOnAddArtifact();
	    }
	});

	eventBus.addHandler(EditArtifactEvent.TYPE, new EditArtifactHandler() {
	    @Override
	    public void onEditArtifact(EditArtifactEvent event) {
		doOnEditArtifact(event.getSelectedArtifactId());
	    }
	});
    }

    private void doOnAddArtifact() {
	History.newItem("add");
    }

    private void doOnEditArtifact(Long id) {
	History.newItem("edit", false);
	ArtifactPresenter presenter = new ArtifactPresenter(service,
		new ArtifactViewImpl(), eventBus, id);
	presenter.go(container);
    }

    private void doOnArtifactAdded() {
	History.newItem("list");
    }

    private void doOnArtifactDeleted() {
	History.newItem("list");
    }

    private void doOnArtifactEditDone() {
	History.newItem("list");
    }

    private void doOnArtifactUpdated() {
	// Nothing to do
    }

    /**
     * "HasWidgets container" = RootPanel passed by EntryPoint
     */
    @Override
    public void go(final HasWidgets container) {
	this.container = container;

	if ("".equals(History.getToken())) {
	    History.newItem("list");
	} else {
	    History.fireCurrentHistoryState();
	}
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {

	String token = event.getValue();

	if (token != null) {

	    if (token.equals("list")) {
		List<ColumnDefinition<Artifact>> columns = ArtifactsColumnDefinitionsFactory
			.getArtifactsListColumnDefinitions();
		new ArtifactsListPresenter(service,
			new ArtifactsListImpl<Artifact>(), columns, eventBus)
			.go(container);

	    } else if (token.equals("add")) {
		new ArtifactPresenter(service, new ArtifactViewImpl(), eventBus)
			.go(container);

	    } else if (token.equals("edit")) {
		new ArtifactPresenter(service, new ArtifactViewImpl(), eventBus)
			.go(container);
	    }
	}

    }
}

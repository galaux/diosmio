package net.alaux.diosmio.gwt.client;

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
import net.alaux.diosmio.gwt.client.presenter.MainAppPresenter;
import net.alaux.diosmio.gwt.client.presenter.PresenterOLD;
import net.alaux.diosmio.gwt.shared.ArtifactDto;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements PresenterOLD, ValueChangeHandler<String> {

    /**
     * RootPanel passed by EntryPoint
     */
    private HasWidgets container;
    private final ArtifactGwtServiceAsync service;
    private final ClientFactory clientFactory;

    private MainAppPresenter mainAppPresenter;

    public AppController(ArtifactGwtServiceAsync service,
	    ClientFactory clientFactory) {

	this.service = service;
	this.clientFactory = clientFactory;

	bind();
    }

    private void bind() {
	History.addValueChangeHandler(this);
	// Artifact
	clientFactory.getEventBus().addHandler(ArtifactAddedEvent.TYPE,
		new ArtifactAddedHandler() {
		    @Override
		    public void onArtifactAdded(ArtifactAddedEvent event) {
			doOnArtifactAdded();
		    }
		});

	clientFactory.getEventBus().addHandler(ArtifactDeletedEvent.TYPE,
		new ArtifactDeletedHandler() {
		    @Override
		    public void onArtifactDeleted(ArtifactDeletedEvent event) {
			doOnArtifactDeleted();
		    }
		});

	clientFactory.getEventBus().addHandler(ArtifactEditDoneEvent.TYPE,
		new ArtifactEditDoneHandler() {
		    @Override
		    public void onArtifactEditDone(ArtifactEditDoneEvent event) {
			doOnArtifactEditDone();
		    }
		});

	clientFactory.getEventBus().addHandler(ArtifactUpdatedEvent.TYPE,
		new ArtifactUpdatedHandler() {
		    @Override
		    public void onArtifactUpdated(ArtifactUpdatedEvent event) {
			doOnArtifactUpdated(event.getArtifact());
		    }
		});

	// Artifacts list
	clientFactory.getEventBus().addHandler(AddArtifactEvent.TYPE,
		new AddArtifactHandler() {
		    @Override
		    public void onAddArtifact(AddArtifactEvent event) {
			doOnAddArtifact();
		    }
		});

	clientFactory.getEventBus().addHandler(EditArtifactEvent.TYPE,
		new EditArtifactHandler() {
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
	mainAppPresenter.showArtifact(id);
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

    private void doOnArtifactUpdated(ArtifactDto artifact) {
	// Let the artifacts list know about the change
	// TODO no need to do this right now as each time we display the
	// artifacts list we instantiate a new ArtifactsListView which retrieves
	// the complete list
    }

    /**
     * "HasWidgets container" = RootPanel passed by EntryPoint
     */
    @Override
    public void go(final HasWidgets container) {
	this.container = container;
	mainAppPresenter = new MainAppPresenter(service,
		clientFactory.getMainAppView(), clientFactory.getEventBus(),
		clientFactory);
	mainAppPresenter.go(container);
	// if ("".equals(History.getToken())) {
	// History.newItem("list");
	// } else {
	// History.fireCurrentHistoryState();
	// }
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {

	String token = event.getValue();

	if (token != null) {

	    if (token.equals("list")) {
		// List<ColumnDefinition<Artifact>> columns =
		// ArtifactsColumnDefinitionsFactory
		// .getArtifactsListColumnDefinitions();
		// new ArtifactsListPresenter(service,
		// new ArtifactsListImpl<Artifact>(), columns,
		// clientFactory.getEventBus()).go(container);
		mainAppPresenter.showArtifactsList();

	    } else if (token.equals("add")) {
		// new ArtifactPresenter(service, new ArtifactViewImpl(),
		// clientFactory.getEventBus()).go(container);
		mainAppPresenter.showArtifact(null);

		// } else if (token.equals("edit")) {
		// new ArtifactPresenter(service, new ArtifactViewImpl(),
		// clientFactory.getEventBus()).go(container);
		// mainAppPresenter.showArtifact(null);
	    }
	}

    }
}

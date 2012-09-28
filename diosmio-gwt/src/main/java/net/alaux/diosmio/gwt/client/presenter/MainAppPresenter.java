package net.alaux.diosmio.gwt.client.presenter;

import java.util.List;

import net.alaux.diosmio.gwt.client.ArtifactGwtServiceAsync;
import net.alaux.diosmio.gwt.client.ClientFactory;
import net.alaux.diosmio.gwt.client.common.ArtifactsColumnDefinitionsFactory;
import net.alaux.diosmio.gwt.client.common.ColumnDefinition;
import net.alaux.diosmio.gwt.client.presenter.artifact.ArtifactPresenter;
import net.alaux.diosmio.gwt.client.presenter.artifact.ArtifactsListPresenter;
import net.alaux.diosmio.gwt.client.view.MainAppView;
import net.alaux.diosmio.gwt.shared.ArtifactDto;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public class MainAppPresenter implements MainAppView.Presenter {

    private final ArtifactGwtServiceAsync service;
    private final MainAppView mainAppView;
    private final HandlerManager eventBus;
    private final ClientFactory clientFactory;

    private ArtifactsListPresenter artifactsListPresenter;

    private HasWidgets container;

    public MainAppPresenter(ArtifactGwtServiceAsync service,
	    MainAppView mainAppView, HandlerManager eventBus,
	    ClientFactory clientFactory) {

	this.service = service;
	this.mainAppView = mainAppView;
	this.eventBus = eventBus;
	this.clientFactory = clientFactory;
    }

    public void go(final HasWidgets container) {
	this.container = container;
	showArtifactsList();
    }

    public void showArtifactsList() {
	// TODO put this in the clientFactory???
	List<ColumnDefinition<ArtifactDto>> columnDefinitions = ArtifactsColumnDefinitionsFactory
		.getArtifactsListColumnDefinitions();

	artifactsListPresenter = new ArtifactsListPresenter(this.service,
		clientFactory.getArtifactsList(), columnDefinitions, eventBus);

	container.clear();
	container.add(mainAppView.asWidget());

	artifactsListPresenter.go(mainAppView.getCenterPanel());
    }

    public void showArtifact(Long id) {
	if (id == null) {
	    ArtifactPresenter presenter = new ArtifactPresenter(service,
		    clientFactory.getArtifactView(),
		    clientFactory.getEventBus());
	    presenter.go(mainAppView.getCenterPanel());
	} else {
	    ArtifactPresenter presenter = new ArtifactPresenter(service,
		    clientFactory.getArtifactView(),
		    clientFactory.getEventBus(), id);
	    presenter.go(mainAppView.getCenterPanel());
	}
    }
}

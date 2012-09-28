package net.alaux.diosmio.gwt.client.presenter.artifact;

import java.util.ArrayList;
import java.util.List;

import net.alaux.diosmio.gwt.client.ArtifactGwtServiceAsync;
import net.alaux.diosmio.gwt.client.common.ColumnDefinition;
import net.alaux.diosmio.gwt.client.common.SelectionModel;
import net.alaux.diosmio.gwt.client.event.artifact.AddArtifactEvent;
import net.alaux.diosmio.gwt.client.event.artifact.EditArtifactEvent;
import net.alaux.diosmio.gwt.client.view.artifact.ArtifactsList;
import net.alaux.diosmio.gwt.shared.ArtifactDto;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class ArtifactsListPresenter implements
	ArtifactsList.Presenter<ArtifactDto> {

    private final ArtifactsList<ArtifactDto> view;
    private final SelectionModel<ArtifactDto> selectionModel;
    private final ArtifactGwtServiceAsync service;
    private final HandlerManager eventBus;

    // Logger logger = Logger.getLogger("ArtifactsListPresenter");

    public static final String NEW_LINE = "\n";

    private final List<ArtifactDto> artifacts;

    public ArtifactsListPresenter(ArtifactGwtServiceAsync service,
	    ArtifactsList<ArtifactDto> view,
	    List<ColumnDefinition<ArtifactDto>> columnDefinitions,
	    HandlerManager eventBus) {

	this.view = view;
	this.service = service;
	this.eventBus = eventBus;
	this.selectionModel = new SelectionModel<ArtifactDto>();

	this.view.setPresenter(this);
	this.view.setColumnDefinitions(columnDefinitions);

	this.artifacts = new ArrayList<ArtifactDto>();
    }

    @Override
    public void onAddButtonClicked() {
	eventBus.fireEvent(new AddArtifactEvent());
    }

    @Override
    public void onDeleteButtonClicked() {
	// Turn selected rows numbers into Artifacts ids
	List<ArtifactDto> selectedContacts = selectionModel.getSelectedItems();
	ArrayList<Long> ids = new ArrayList<Long>();

	for (int i = 0; i < selectedContacts.size(); ++i) {
	    ids.add(selectedContacts.get(i).getId());
	}

	if (ids.size() != 0) {
	    service.deleteArtifacts(ids, new AsyncCallback<List<Long>>() {

		@Override
		public void onSuccess(List<Long> result) {
		    // TODO see if delete could return a list of all remaining
		    // Artifacts
		    // Remove artifacts which ids belong to the deletedList
		    List<ArtifactDto> oldArtifactsList = new ArrayList<ArtifactDto>(
			    artifacts);
		    for (ArtifactDto artifact : oldArtifactsList) {
			if (result.contains(artifact.getId())) {
			    artifacts.remove(artifact);
			}
		    }

		    // Display result in view
		    view.setRowData(artifacts);
		}

		@Override
		public void onFailure(Throwable caught) {
		    // logger.log(Level.SEVERE, caught.toString());
		    Window.alert("An error occured while trying to delete the artifacts.");
		}
	    });
	}
    }

    @Override
    public void onItemClicked(ArtifactDto clickedItem) {
	eventBus.fireEvent(new EditArtifactEvent(clickedItem.getId()));
    }

    @Override
    public void onItemSelected(ArtifactDto selectedItem) {
	if (selectionModel.isSelected(selectedItem)) {
	    selectionModel.removeSelection(selectedItem);
	} else {
	    selectionModel.addSelection(selectedItem);
	}
    }

    public void go(HasWidgets container) {
	container.clear();
	container.add(view.asWidget());
	fetchArtifactsList();
    }

    private void fetchArtifactsList() {
	service.getAllArtifacts(new AsyncCallback<List<ArtifactDto>>() {
	    @Override
	    public void onSuccess(List<ArtifactDto> result) {
		// Display result in view
		if (result != null && result.size() > 0) {
		    artifacts.clear();
		    artifacts.addAll(result);
		    view.setRowData(artifacts);
		}

	    }

	    @Override
	    public void onFailure(Throwable caught) {
		// logger.log(Level.SEVERE, caught.toString());
		Window.alert("Error while trying to retieve artifacts list"
			+ NEW_LINE + caught.getMessage());
	    }
	});
    }
}

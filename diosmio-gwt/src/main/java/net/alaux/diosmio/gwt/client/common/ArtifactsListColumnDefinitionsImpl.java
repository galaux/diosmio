package net.alaux.diosmio.gwt.client.common;

import java.util.ArrayList;

import net.alaux.diosmio.gwt.shared.Artifact;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class ArtifactsListColumnDefinitionsImpl extends
	ArrayList<ColumnDefinition<Artifact>> {

    private static final long serialVersionUID = -6390998325977877364L;

    private static ArtifactsListColumnDefinitionsImpl instance = null;

    public static ArtifactsListColumnDefinitionsImpl getInstance() {
	if (instance == null) {
	    instance = new ArtifactsListColumnDefinitionsImpl();
	}
	return instance;
    }

    protected ArtifactsListColumnDefinitionsImpl() {

	this.add(new ColumnDefinition<Artifact>() {
	    @Override
	    public Widget render(Artifact a) {
		return new CheckBox();
	    }

	    @Override
	    public boolean isSelectable() {
		return true;
	    }
	});

	this.add(new ColumnDefinition<Artifact>() {
	    @Override
	    public Widget render(Artifact artifact) {
		return new HTML(artifact.getId().toString());
	    }

	    @Override
	    public boolean isClickable() {
		return true;
	    }
	});

	this.add(new ColumnDefinition<Artifact>() {
	    @Override
	    public Widget render(Artifact artifact) {
		return new HTML(artifact.getName());
	    }

	    @Override
	    public boolean isClickable() {
		return true;
	    }
	});
    }
}

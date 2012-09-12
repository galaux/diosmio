package net.alaux.diosmio.gwt.client.view.artifact;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public interface ArtifactView {

    public interface Presenter {

	void onSaveButtonClicked();

	void onDeleteButtonClicked();

	void onCloseButtonClicked();

	void go(final HasWidgets container);
    }

    void setPresenter(Presenter presenter);

    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    Widget asWidget();
}
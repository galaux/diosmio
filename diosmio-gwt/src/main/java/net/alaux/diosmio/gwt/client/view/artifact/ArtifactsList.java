package net.alaux.diosmio.gwt.client.view.artifact;

import java.util.List;

import net.alaux.diosmio.gwt.client.common.ColumnDefinition;

import com.google.gwt.user.client.ui.Widget;

public interface ArtifactsList<T> {

    public interface Presenter<T> {

	void onAddButtonClicked();

	void onDeleteButtonClicked();

	void onItemClicked(T clickedItem);

	void onItemSelected(T selectedItem);
    }

    void setPresenter(Presenter<T> presenter);

    void setColumnDefinitions(List<ColumnDefinition<T>> columnDefinitions);

    void setRowData(List<T> rowData);

    Widget asWidget();
}

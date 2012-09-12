package net.alaux.diosmio.gwt.client.view.artifact;

import java.util.List;

import net.alaux.diosmio.gwt.client.common.ColumnDefinition;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.EventTarget;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.dom.client.TableRowElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class ArtifactsListImpl<T> extends Composite implements ArtifactsList<T> {

    @UiTemplate("ArtifactsList.ui.xml")
    interface ArtifactsListUiBinder extends UiBinder<Widget, ArtifactsListImpl> {
    }

    private static ArtifactsListUiBinder uiBinder = GWT
	    .create(ArtifactsListUiBinder.class);

    @UiField
    FlexTable artifactsTable;

    @UiField
    Button delSelectedButton;

    @UiField
    Button addArtifactButton;

    private Presenter<T> presenter;
    private List<ColumnDefinition<T>> columnDefinitions;
    private List<T> rowData;

    public ArtifactsListImpl() {
	initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setPresenter(Presenter<T> presenter) {
	this.presenter = presenter;
    }

    @Override
    public void setColumnDefinitions(List<ColumnDefinition<T>> columnDefinitions) {
	this.columnDefinitions = columnDefinitions;
    }

    @Override
    public void setRowData(List<T> data) {
	artifactsTable.removeAllRows();
	this.rowData = data;

	for (int i = 0; i < rowData.size(); ++i) {
	    T t = rowData.get(i);
	    for (int j = 0; j < columnDefinitions.size(); ++j) {
		ColumnDefinition<T> columnDefinition = columnDefinitions.get(j);
		artifactsTable.setWidget(i, j, columnDefinition.render(t));
	    }
	}
    }

    @UiHandler("addArtifactButton")
    public void onClickAddArtifactButton(ClickEvent event) {
	if (presenter != null) {
	    presenter.onAddButtonClicked();
	}
    }

    private TableCellElement findNearestParentCell(Node node) {
	while ((node != null)) {
	    if (Element.is(node)) {
		Element elem = Element.as(node);

		String tagName = elem.getTagName();
		if ("td".equalsIgnoreCase(tagName)
			|| "th".equalsIgnoreCase(tagName)) {
		    return elem.cast();
		}
	    }
	    node = node.getParentNode();
	}
	return null;
    }

    @UiHandler("artifactsTable")
    public void onClickArtifactsTable(ClickEvent event) {
	if (presenter != null) {
	    EventTarget target = event.getNativeEvent().getEventTarget();
	    Node node = Node.as(target);
	    TableCellElement cell = findNearestParentCell(node);
	    if (cell == null) {
		return;
	    }

	    TableRowElement tr = TableRowElement.as(cell.getParentElement());
	    int row = tr.getSectionRowIndex();

	    if (cell != null) {
		if (shouldFireClickEvent(cell)) {
		    presenter.onItemClicked(rowData.get(row));
		}
		if (shouldFireSelectEvent(cell)) {
		    presenter.onItemSelected(rowData.get(row));
		}
	    }
	}
    }

    private boolean shouldFireClickEvent(TableCellElement cell) {
	boolean shouldFireClickEvent = false;

	if (cell != null) {
	    ColumnDefinition<T> columnDefinition = columnDefinitions.get(cell
		    .getCellIndex());

	    if (columnDefinition != null) {
		shouldFireClickEvent = columnDefinition.isClickable();
	    }
	}

	return shouldFireClickEvent;
    }

    private boolean shouldFireSelectEvent(TableCellElement cell) {
	boolean shouldFireSelectEvent = false;

	if (cell != null) {
	    ColumnDefinition<T> columnDefinition = columnDefinitions.get(cell
		    .getCellIndex());

	    if (columnDefinition != null) {
		shouldFireSelectEvent = columnDefinition.isSelectable();
	    }
	}

	return shouldFireSelectEvent;
    }

    @UiHandler("delSelectedButton")
    public void onClickDelSelectedButton(ClickEvent event) {
	if (presenter != null) {
	    presenter.onDeleteButtonClicked();
	}
    }

    // @Override
    // public int getClickedRow(ClickEvent event) {
    // int selectedRow = -1;
    //
    // HTMLTable.Cell clickedCell = artifactsTable.getCellForEvent(event);
    // // Suppress clicks if the user is actually selecting the check box
    // if (clickedCell != null) {
    // selectedRow = clickedCell.getRowIndex();
    // }
    //
    // return selectedRow;
    // }
    //
    // @Override
    // public List<Integer> getSelectedRows() {
    // List<Integer> selectedRows = new ArrayList<Integer>();
    //
    // for (int i = 0; i < artifactsTable.getRowCount(); ++i) {
    // CheckBox checkBox = (CheckBox) artifactsTable.getWidget(i, 0);
    // if (checkBox.getValue()) {
    // selectedRows.add(i);
    // }
    // }
    //
    // return selectedRows;
    // }
}

package net.alaux.diosmio.gwt.client.view;

import net.alaux.diosmio.gwt.client.presenter.ArtifactPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ArtifactPanel extends Composite implements
	ArtifactPresenter.Display {

    private static ArtifactPanelUiBinder uiBinder = GWT
	    .create(ArtifactPanelUiBinder.class);

    interface ArtifactPanelUiBinder extends UiBinder<Widget, ArtifactPanel> {
    }

    @UiField
    TextBox textBoxId;

    @UiField
    TextBox textBoxName;

    @UiField
    Button deleteButton;

    @UiField
    Button saveButton;

    @UiField
    Button closeButton;

    public ArtifactPanel() {
	initWidget(uiBinder.createAndBindUi(this));
	textBoxId.setEnabled(false);
    }

    @Override
    public HasValue<String> getId() {
	return textBoxId;
    }

    @Override
    public HasValue<String> getName() {
	return textBoxName;
    }

    @Override
    public HasClickHandlers getDeleteButton() {
	return deleteButton;
    }

    @Override
    public HasClickHandlers getSaveButton() {
	return saveButton;
    }

    @Override
    public HasClickHandlers getCloseButton() {
	return closeButton;
    }

    @Override
    public Widget asWidget() {
	return this;
    }
}

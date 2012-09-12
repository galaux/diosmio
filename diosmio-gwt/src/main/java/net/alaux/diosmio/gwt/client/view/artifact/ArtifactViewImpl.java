package net.alaux.diosmio.gwt.client.view.artifact;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LongBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ArtifactViewImpl extends Composite implements ArtifactView {

    private static ArtifactViewUiBinder uiBinder = GWT
	    .create(ArtifactViewUiBinder.class);

    @UiTemplate("ArtifactView.ui.xml")
    interface ArtifactViewUiBinder extends UiBinder<Widget, ArtifactViewImpl> {
    }

    @UiField
    LongBox longBoxId;

    @UiField
    TextBox textBoxName;

    @UiField
    Button deleteButton;

    @UiField
    Button saveButton;

    @UiField
    Button closeButton;

    private Presenter presenter;

    public ArtifactViewImpl() {
	initWidget(uiBinder.createAndBindUi(this));
	longBoxId.setEnabled(false);
    }

    @Override
    public void setPresenter(Presenter presenter) {
	this.presenter = presenter;
    }

    @UiHandler("deleteButton")
    void onClickDeleteButton(ClickEvent event) {
	presenter.onDeleteButtonClicked();
    }

    @UiHandler("saveButton")
    void onClickSaveButton(ClickEvent event) {
	presenter.onSaveButtonClicked();
    }

    @UiHandler("closeButton")
    void onClickCloseButton(ClickEvent event) {
	presenter.onCloseButtonClicked();
    }

    @Override
    public Long getId() {
	return longBoxId.getValue();
    }

    @Override
    public void setId(Long id) {
	longBoxId.setValue(id);
    }

    @Override
    public String getName() {
	return textBoxName.getValue();
    }

    @Override
    public void setName(String name) {
	textBoxName.setValue(name);
    }

}

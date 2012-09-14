package net.alaux.diosmio.gwt.client.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class MainAppViewImpl extends Composite implements MainAppView {

    private static MainAppViewUiBinder uiBinder = GWT
	    .create(MainAppViewUiBinder.class);

    @UiTemplate("MainAppView.ui.xml")
    interface MainAppViewUiBinder extends UiBinder<Widget, MainAppViewImpl> {
    }

    private final List<Widget> widgets = new ArrayList<Widget>();

    @UiField
    HTMLPanel centerPanel;

    public MainAppViewImpl() {
	initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void add(Widget w) {
	widgets.add(w);
    }

    @Override
    public void clear() {
	widgets.clear();
    }

    @Override
    public Iterator<Widget> iterator() {
	return widgets.iterator();
    }

    @Override
    public boolean remove(Widget w) {
	return widgets.remove(w);
    }

    @Override
    public HasWidgets getCenterPanel() {
	return centerPanel;
    }

}

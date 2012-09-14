package net.alaux.diosmio.gwt.client.view;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;

public interface MainAppView extends HasWidgets, IsWidget {

    public interface Presenter {

    }

    public HasWidgets getCenterPanel();
}

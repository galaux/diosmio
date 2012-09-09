package net.alaux.diosmio.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

public class DiosMioGwt implements EntryPoint {

    // private final Messages messages = GWT.create(Messages.class);
    // final Button sendButton = new Button( messages.sendButton() );

    /**
     * This is the entry point method.
     */
    @Override
    public void onModuleLoad() {
	ArtifactServiceAsync rpcService = GWT.create(ArtifactService.class);
	HandlerManager eventBus = new HandlerManager(null);
	AppController appViewer = new AppController(rpcService, eventBus);
	appViewer.go(RootPanel.get());
    }

}

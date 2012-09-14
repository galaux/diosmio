package net.alaux.diosmio.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class DiosMioGwt implements EntryPoint {

    // private final Messages messages = GWT.create(Messages.class);
    // final Button sendButton = new Button( messages.sendButton() );

    /**
     * This is the entry point method.
     */
    @Override
    public void onModuleLoad() {

	ClientFactory clientFactory = GWT.create(ClientFactoryImpl.class);

	ArtifactServiceAsync artifactService = GWT
		.create(ArtifactService.class);

	AppController appController = new AppController(artifactService,
		clientFactory);

	appController.go(RootLayoutPanel.get());
    }

}

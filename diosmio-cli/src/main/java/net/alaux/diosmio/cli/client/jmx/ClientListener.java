package net.alaux.diosmio.cli.client.jmx;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationListener;

import net.alaux.diosmio.cli.Main;

public class ClientListener implements NotificationListener {

    // Could be used if client were to be contacted by server
    @Override
    public void handleNotification(Notification notification, Object handback) {
	Main.out.println("\nReceived notification:");
	Main.out.println("\tClassName: " + notification.getClass().getName());
	Main.out.println("\tSource: " + notification.getSource());
	Main.out.println("\tType: " + notification.getType());
	Main.out.println("\tMessage: " + notification.getMessage());
	if (notification instanceof AttributeChangeNotification) {
	    AttributeChangeNotification acn = (AttributeChangeNotification) notification;
	    Main.out.println("\tAttributeName: " + acn.getAttributeName());
	    Main.out.println("\tAttributeType: " + acn.getAttributeType());
	    Main.out.println("\tNewValue: " + acn.getNewValue());
	    Main.out.println("\tOldValue: " + acn.getOldValue());
	}
    }
}
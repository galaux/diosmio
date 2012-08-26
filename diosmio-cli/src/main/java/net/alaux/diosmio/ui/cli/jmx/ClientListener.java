package net.alaux.diosmio.ui.cli.jmx;

import net.alaux.diosmio.ui.cli.Main;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationListener;

public class ClientListener implements NotificationListener {


    // Er.... say again what *this* is used for? TODO remove?
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
package net.alaux.diosmio.ui.cli.core;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/7/12
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class CliMiscActions extends CliActions {

    public static void displayMBeanList() throws IOException, MalformedObjectNameException {

        initJmxConnection();

        Set<ObjectName> names = new TreeSet<ObjectName>(mbsc.queryNames(null, null));

        for (ObjectName name : names) {
            if (name.toString().startsWith(DM_DOMAIN_NAME)) {
                System.out.println(name.toString().replaceFirst(DM_DOMAIN_NAME + ":name=", ""));
            }
        }

        closeJmxConnection();
    }
}

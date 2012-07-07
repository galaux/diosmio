package net.alaux.diosmio.ui.cli.core;

import net.alaux.diosmio.core.services.IArtifactManager;
import net.alaux.diosmio.ui.cli.ClientListener;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.management.InstanceNotFoundException;
import javax.management.JMX;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/7/12
 * Time: 7:17 PM
 * To change this template use File | Settings | File Templates.
 */
//throws IOException, MalformedObjectNameException, InstanceNotFoundException
public class CliArtifactManagerActions extends CliActions {

    private static final String BEAN_NAME = "artifactManager";

    public static void addArtifact(String arg) throws IOException, InstanceNotFoundException, MalformedObjectNameException {

        System.out.println("listArtifacts");

        initJmxConnection();

        IArtifactManager artifactManager = getServiceBean(IArtifactManager.class);

        File[] artifactList = artifactManager.listArtifacts();

        System.out.println("\nGot " + artifactList.length + " files.");

        closeJmxConnection();
    }

    public static void listArtifacts() throws IOException, InstanceNotFoundException, MalformedObjectNameException {

        initJmxConnection();

        IArtifactManager artifactManager = getServiceBean(IArtifactManager.class);

        File[] artifactList = artifactManager.listArtifacts();

        Arrays.sort(artifactList);
        for (File artifact : artifactList) {
            System.out.println(artifact.getName());
        }

        closeJmxConnection();
    }

    public static boolean deleteArtifact(String arg) {
        System.out.println("deleteArtifact");
        throw  new NotImplementedException();
    }
}

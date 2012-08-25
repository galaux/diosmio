package net.alaux.diosmio.ui.cli;

import javax.management.InstanceNotFoundException;
import javax.management.MalformedObjectNameException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 8/4/12
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
public interface DiosMioCli {

    void displayStatus() throws Exception;
    void listAllArtifacts() throws Exception, MalformedObjectNameException, InstanceNotFoundException;
    void showArtifact(Long id) throws Exception, MalformedObjectNameException, InstanceNotFoundException;
    void createArtifact(String path) throws Exception, MalformedObjectNameException, InstanceNotFoundException;
    void deleteArtifact(Long id) throws Exception, MalformedObjectNameException, InstanceNotFoundException;

    void loadFile(String filePath) throws Exception;
    void parseFile(String filePath) throws Exception;

    public void createConfiguration(String hostname, String sshPort, String sshUser) throws MalformedObjectNameException, InstanceNotFoundException, IOException;
    public void readConfiguration(Long id) throws MalformedObjectNameException, InstanceNotFoundException, IOException;
    public void listAllConfigurations() throws MalformedObjectNameException, InstanceNotFoundException, IOException;
}

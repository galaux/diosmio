package net.alaux.diosmio.ui.cli;

import javax.management.InstanceNotFoundException;
import javax.management.MalformedObjectNameException;

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
}

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

    public void close();

    void displayMBeanList() throws IOException, MalformedObjectNameException;
    void displayStatus() throws Exception;
    void listAllArtifacts() throws IOException, MalformedObjectNameException, InstanceNotFoundException;
    void showArtifact(Long id) throws IOException, MalformedObjectNameException, InstanceNotFoundException;
    void create(String filePath) throws Exception, MalformedObjectNameException, InstanceNotFoundException;
    void delete(Long id) throws Exception, MalformedObjectNameException, InstanceNotFoundException;
}

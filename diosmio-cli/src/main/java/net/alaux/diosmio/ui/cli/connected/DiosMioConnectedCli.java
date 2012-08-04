package net.alaux.diosmio.ui.cli.connected;

import net.alaux.diosmio.ui.cli.DiosMioCli;

import javax.management.InstanceNotFoundException;
import javax.management.MalformedObjectNameException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 8/4/12
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class DiosMioConnectedCli implements DiosMioCli {

    public DiosMioConnectedCli() {
        // TODO Connect here
    }

    public void close() {
        // TODO Close here
    }

    public void displayMBeanList() throws IOException, MalformedObjectNameException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void displayStatus() throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void listAllArtifacts() throws IOException, MalformedObjectNameException, InstanceNotFoundException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void showArtifact(Long id) throws IOException, MalformedObjectNameException, InstanceNotFoundException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void create(String filePath) throws Exception, MalformedObjectNameException, InstanceNotFoundException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void delete(Long id) throws Exception, MalformedObjectNameException, InstanceNotFoundException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

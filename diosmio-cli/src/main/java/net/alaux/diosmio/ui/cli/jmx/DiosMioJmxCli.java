package net.alaux.diosmio.ui.cli.jmx;

import net.alaux.diosmio.services.core.ArtifactManager;
import net.alaux.diosmio.services.dao.db.ConfigDao;
import net.alaux.diosmio.ui.cli.DiosMioCli;
import net.alaux.diosmio.ui.cli.Main;

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
// TODO split this class between "connection independant business stuff" and "connection stuff"
public class DiosMioJmxCli extends DiosMioCli {

    private String url;
    private String domain;

    private JmxConnection diosMioJmxConnection;

    public DiosMioJmxCli(String url, String domain) {
        this.url = url;
        this.domain = domain;
    }

    private JmxConnection getJmxConnection() {

        if (diosMioJmxConnection == null) {
            try {
                diosMioJmxConnection = new JmxConnection(url, domain);
            } catch (IOException e) {
                throw new RuntimeException(Main.bundle.getString("error.server_connection") ,e);
            }
        }

        return diosMioJmxConnection;
    }

    public ArtifactManager getArtifactManager() {

        if (artifactManager == null) {
            try {
                artifactManager = getJmxConnection().getServiceBean(ArtifactManager.class);
            } catch (MalformedObjectNameException e) {
                throw new RuntimeException(Main.bundle.getString("error.server_connection") ,e);
            } catch (InstanceNotFoundException e) {
                throw new RuntimeException(Main.bundle.getString("error.server_connection") ,e);
            }
        }
        return artifactManager;
    }

    public ConfigDao getConfigDao() {
        if (configDao == null) {
            try {
                configDao = getJmxConnection().getServiceBean(ConfigDao.class);
            } catch (InstanceNotFoundException e) {
                throw new RuntimeException(Main.bundle.getString("error.server_connection") ,e);
            } catch (MalformedObjectNameException e) {
                throw new RuntimeException(Main.bundle.getString("error.server_connection") ,e);
            }
        }
        return configDao;
    }

    public void close() {
        if (diosMioJmxConnection != null) {
            try {
                diosMioJmxConnection.closeJmxConnection();
            } catch (IOException e) {
                throw new RuntimeException(Main.bundle.getString("error.server_connection") ,e);
            }
        }
    }

}

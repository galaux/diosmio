package net.alaux.diosmio.ui.cli.jmx;

import net.alaux.diosmio.services.core.ArtifactManager;
import net.alaux.diosmio.services.dao.db.ConfigDao;
import net.alaux.diosmio.ui.cli.CliClient;
import net.alaux.diosmio.ui.cli.Main;

import javax.management.InstanceNotFoundException;
import javax.management.MalformedObjectNameException;
import java.io.IOException;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net>
 */
public class CliJmxClient extends CliClient {

    private String url;
    private String domain;

    private JmxConnection diosMioJmxConnection;

    public CliJmxClient(String url, String domain) {
        this.url = url;
        this.domain = domain;
    }

    private JmxConnection getJmxConnection() {

        if (diosMioJmxConnection == null) {
            try {
                diosMioJmxConnection = new JmxConnection(url, domain);
            } catch (IOException e) {
                throw new RuntimeException(Main.bundle.getString("error.server_connection"), e);
            }
        }

        return diosMioJmxConnection;
    }

    public ArtifactManager getArtifactManager() {

        if (artifactManager == null) {
            try {
                artifactManager = getJmxConnection().getServiceBean(ArtifactManager.class);
            } catch (MalformedObjectNameException e) {
                throw new RuntimeException(Main.bundle.getString("error.server_connection"), e);
            } catch (InstanceNotFoundException e) {
                throw new RuntimeException(Main.bundle.getString("error.server_connection"), e);
            }
        }
        return artifactManager;
    }

    public ConfigDao getConfigDao() {
        if (configDao == null) {
            try {
                configDao = getJmxConnection().getServiceBean(ConfigDao.class);
            } catch (InstanceNotFoundException e) {
                throw new RuntimeException(Main.bundle.getString("error.server_connection"), e);
            } catch (MalformedObjectNameException e) {
                throw new RuntimeException(Main.bundle.getString("error.server_connection"), e);
            }
        }
        return configDao;
    }

    public void close() {
        if (diosMioJmxConnection != null) {
            try {
                diosMioJmxConnection.closeJmxConnection();
            } catch (IOException e) {
                throw new RuntimeException(Main.bundle.getString("error.server_connection"), e);
            }
        }
    }
}

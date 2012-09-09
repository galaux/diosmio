package net.alaux.diosmio.ui.cli.jmx;

import net.alaux.diosmio.services.core.ArtifactManager;
import net.alaux.diosmio.services.dao.db.ConfigDao;
import net.alaux.diosmio.ui.cli.CliClient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net>
 * Date: 8/27/12
 */
public class CliRmiClient extends CliClient {

    private int artifactManagerRmiPort;
    private int configDaoRmiPort;

    private ArtifactManager artifactManager;
    private ConfigDao configDao;

    public CliRmiClient(int artifactManagerRmiPort, int configDaoRmiPort) {
        this.artifactManagerRmiPort = artifactManagerRmiPort;
        this.configDaoRmiPort = configDaoRmiPort;
    }

    @Override
    public ArtifactManager getArtifactManager() {

        if (artifactManager == null) {
            // TODO Investigate the use of this
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            try {
                Registry registry = LocateRegistry.getRegistry(artifactManagerRmiPort);
                artifactManager = (ArtifactManager) registry.lookup("artifactManager");
            } catch (Exception e) {
                // TODO add error message
                throw new RuntimeException(e);
            }
        }

        return artifactManager;
    }

    @Override
    public ConfigDao getConfigDao() {

        if (configDao == null) {
            // TODO Investigate the use of this
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            try {
                Registry registry = LocateRegistry.getRegistry(artifactManagerRmiPort);
                configDao = (ConfigDao) registry.lookup("configDao");
            } catch (Exception e) {
                // TODO add error message
                throw new RuntimeException(e);
            }
        }

        return configDao;
    }

    @Override
    public void close() {
        // Nothing to do
    }
}

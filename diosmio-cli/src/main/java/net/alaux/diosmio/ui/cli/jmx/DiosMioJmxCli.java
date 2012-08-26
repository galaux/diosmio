package net.alaux.diosmio.ui.cli.jmx;

import net.alaux.diosmio.services.core.ArtifactManager;
import net.alaux.diosmio.services.dao.db.ConfigDao;
import net.alaux.diosmio.services.entity.Artifact;
import net.alaux.diosmio.services.entity.Configuration;
import net.alaux.diosmio.services.entity.impl.HostConfig;
import net.alaux.diosmio.ui.cli.DiosMioCli;
import net.alaux.diosmio.ui.cli.Main;
import net.alaux.utils.AppMessages;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.management.InstanceNotFoundException;
import javax.management.MalformedObjectNameException;
import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 8/4/12
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class DiosMioJmxCli implements DiosMioCli {

    private static final String JSON_TAG_ARTIFACTS = "artifacts";

    private String url;
    private String domain;

    private JmxConnection diosMioJmxConnection;

    private ArtifactManager artifactManager;

    private ConfigDao configDao;

    private AppMessages appMessages;

    public DiosMioJmxCli(String url, String domain) {
        this.url = url;
        this.domain = domain;
    }

    private JmxConnection getJmxConnection() {

        if (diosMioJmxConnection == null) {
            try {
                diosMioJmxConnection = new JmxConnection(url, domain);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return diosMioJmxConnection;
    }

    public ArtifactManager getArtifactManager() {

        if (artifactManager == null) {
            try {
                artifactManager = getJmxConnection().getServiceBean(ArtifactManager.class);
            } catch (MalformedObjectNameException e) {
                throw new RuntimeException(e);
            } catch (InstanceNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return artifactManager;
    }

    public ConfigDao getConfigDao() {
        if (configDao == null) {
            try {
                configDao = getJmxConnection().getServiceBean(ConfigDao.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InstanceNotFoundException e) {
                throw new RuntimeException(e);
            } catch (MalformedObjectNameException e) {
                throw new RuntimeException(e);
            }
        }
        return configDao;
    }

    public void close() throws IOException {
        if (diosMioJmxConnection != null) {
            diosMioJmxConnection.closeJmxConnection();
        }
    }


    // Artifact ***************************************************************

    public void listAllArtifacts() {

        List<Artifact> artifacts = getArtifactManager().getAll();

        for (Artifact artifact : artifacts) {
            Main.out.println(artifact);
        }
    }

    public void showArtifact(Long id) {

        Artifact artifact = getArtifactManager().get(id);
        if (artifact != null) {
            Main.out.println(artifact);
        } else {
            Main.out.println("Artifact not found");
        }
    }

    private void createArtifact(File file) {

        Main.logger.info("Creating artifact " + file.getName());

        try {
            FileInputStream fis = new FileInputStream(file);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }

            getArtifactManager().create(file.getName(), bos.toByteArray());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(MessageFormat.format(Main.bundle.getString("error.access.read"), file.getAbsolutePath()), e);
        } catch (IOException e) {
            throw new RuntimeException(MessageFormat.format(Main.bundle.getString("error.access.read"), file.getAbsolutePath()), e);
        }
    }

    public void createArtifact(String path) {

        File file = new File(path);
        if (file == null || !file.exists() || !file.canRead()) {
            throw new RuntimeException(MessageFormat.format(Main.bundle.getString("error.access.read"), path));
        }

        if (file.isFile()) {
            createArtifact(file);
        } else {
            Main.logger.info("Scanning for files in " + path + ".");
            List<File> files = getFilesOfExtension(file, "war");
            Main.logger.info(" Found " + files.size());
            for (File f : files) {
                try {
                    createArtifact(f);

                } catch (RuntimeException e) {
                    Main.err.println(e);
                    Main.logger.logException(e);
                    // On error, continue with other elements creation
                }
            }
        }
    }

    private List<File> getFilesOfExtension(File dir, String extension) {

        List<File> resultList = new ArrayList<File>();
        final String fullExtension = "." + extension;
        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File file, String s) {
                return s.endsWith(fullExtension);
            }
        });

        if (files != null) {
            resultList.addAll(Arrays.asList(files));
        }

        File[] dirs = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });

        if (dirs != null) {
            for (File subDirs : dirs) {
                resultList.addAll(getFilesOfExtension(subDirs, extension));
            }
        }

        return resultList;
    }

    public void deleteArtifact(Long id) {

        Artifact artifact = getArtifactManager().get(id);

        if (artifact == null) {
            // TODO create and use a "consoleWriter" -> reuse KissLogger?
            Main.out.println("Cannot find artifact");
        } else {
            artifactManager.delete(artifact);
            Main.out.println("Artifact deleted");
        }
    }


    // Configuration **********************************************************

    public void createConfiguration(String hostname, String sshPort, String sshUser) {

        HostConfig hostConfig = new HostConfig(hostname, sshPort, sshUser);
        getConfigDao().create(hostConfig);
    }

    public void readConfiguration(Long id) {

        HostConfig hostConfig = getConfigDao().read(id);
        Main.out.println(hostConfig);
    }

    public void listAllConfigurations() {

        List<Configuration> configurations = getConfigDao().readAll();

        for (Configuration configuration : configurations) {
            Main.out.println(((HostConfig)configuration).toString());
        }
    }


    // Automatic loading ******************************************************

    public void loadFile(String filePath) {

        File file = new File(filePath);
        if (file == null || !file.canRead()) {
            throw new RuntimeException(MessageFormat.format(appMessages.get("cli.error.cannot_read_file"), filePath));
        }

        List<Artifact> artifacts = new ArrayList<Artifact>();
        parseFile(file, artifacts);
//        for (Artifact artifact : artifacts) {
//            createArtifact();
//        }
    }

    public void parseFile(String filePath) {

        File file = new File(filePath);
        if (file == null || !file.canRead()) {
            throw new RuntimeException(MessageFormat.format(appMessages.get("cli.error.cannot_read_file"), filePath));
        }

        List<Artifact> artifacts = new ArrayList<Artifact>();
        parseFile(file, artifacts);
        Main.out.println("Found " + artifacts.size() + " artifacts");
    }

    private void parseFile(File file, List<Artifact> artifacts) {

        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(file));

            if (jsonObject.containsKey(JSON_TAG_ARTIFACTS)) {
                JSONArray jsonArray = (JSONArray) jsonObject.get(JSON_TAG_ARTIFACTS);

                Iterator<JSONObject> iterator = jsonArray.iterator();
                while (iterator.hasNext()) {
                    artifacts.add(new Artifact(iterator.next()));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(MessageFormat.format(appMessages.get("cli.error.cannot_read_file"), file.getAbsolutePath()));
        } catch (ParseException e) {
            throw new RuntimeException(MessageFormat.format(appMessages.get("error.json.parse"), file.getAbsolutePath()));
        }
    }
}

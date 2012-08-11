package net.alaux.diosmio.ui.cli.connected;

import net.alaux.diosmio.services.core.ArtifactManager;
import net.alaux.diosmio.services.entity.Artifact;
import net.alaux.diosmio.ui.cli.DiosMioCli;
import net.alaux.diosmio.ui.cli.jmxcli.DiosMioJmxConnection;
import net.alaux.utils.AppException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.management.InstanceNotFoundException;
import javax.management.MalformedObjectNameException;
import java.io.*;
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
public class DiosMioConnectedCli implements DiosMioCli {

    private static final String JSON_TAG_ARTIFACTS = "artifacts";

    private String url;
    private String domain;

    private DiosMioJmxConnection diosMioJmxConnection;

    private ArtifactManager artifactManager;

    public DiosMioConnectedCli(String url, String domain) throws IOException, MalformedObjectNameException, InstanceNotFoundException {

        this.url = url;
        this.domain = domain;
    }

    public void close() throws IOException {
        if (diosMioJmxConnection != null) {
            diosMioJmxConnection.closeJmxConnection();
        }
    }

    private DiosMioJmxConnection getJmxConnection() throws IOException {
        if (diosMioJmxConnection == null) {
            diosMioJmxConnection = new DiosMioJmxConnection(url, domain);
        }

        return diosMioJmxConnection;
    }

    public ArtifactManager getArtifactManager() throws MalformedObjectNameException, InstanceNotFoundException, IOException {
        if (artifactManager == null) {
            artifactManager = getJmxConnection().getServiceBean(ArtifactManager.class);
        }
        return artifactManager;
    }

//    public void displayMBeanList() throws IOException, MalformedObjectNameException {
//        //To change body of implemented methods use File | Settings | File Templates.
//    }

    public void displayStatus() throws Exception {
        System.out.println(getArtifactManager().getStatus());
    }

    public void listAllArtifacts() throws IOException, MalformedObjectNameException, InstanceNotFoundException {

        List<Artifact> artifacts = getArtifactManager().getAll();

        for (Artifact artifact : artifacts) {
            System.out.println(artifact);
        }
    }

    public void showArtifact(Long id) throws IOException, MalformedObjectNameException, InstanceNotFoundException {

        Artifact artifact = getArtifactManager().get(id);
        if (artifact != null) {
            System.out.println(artifact);
        } else {
            System.out.println("Artifact not found");
        }
    }

    public void createArtifact(String filePath) throws Exception, MalformedObjectNameException, InstanceNotFoundException {

        File file = new File(filePath);
        if (file == null || !file.canRead()) {
            throw new Exception("cli.error.cannot_read_file");
        }

        createArtifact(file);
    }

    private void createArtifact(File file) throws IOException, AppException, MalformedObjectNameException, InstanceNotFoundException {
        FileInputStream fis = new FileInputStream(file);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        for (int readNum; (readNum = fis.read(buf)) != -1;) {
            bos.write(buf, 0, readNum);
        }

        getArtifactManager().create(file, bos.toByteArray());
    }

    public void createAllArtifacts(String dirPath) throws Exception, InstanceNotFoundException {

        File dir = new File(dirPath);
        if (dir == null
                || !dir.exists()
                || !dir.canRead()
                || !dir.isDirectory()) {
            throw new Exception("error.file_not_accessible");
        }

        List<File> files = getFilesOfExtension(dir, "war");
        for (File file : files) {
            createArtifact(file);
        }
    }

    private List<File> getFilesOfExtension(File dir, String extension) throws Exception {

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

    public void deleteArtifact(Long id) throws Exception, MalformedObjectNameException, InstanceNotFoundException {

        Artifact artifact = getArtifactManager().get(id);

        if (artifact == null) {
            System.out.println("Cannot find artifact");
        } else {
            artifactManager.delete(artifact);
            System.out.println("Artifact deleted");
        }
    }

    public void loadFile(String filePath) throws Exception {

        File file = new File(filePath);
        if (file == null || !file.canRead()) {
            throw new Exception("cli.error.cannot_read_file");
        }

        List<Artifact> artifacts = new ArrayList<Artifact>();
        parseFile(file, artifacts);
//        for (Artifact artifact : artifacts) {
//            createArtifact();
//        }
    }

    public void parseFile(String filePath) throws Exception {

        File file = new File(filePath);
        if (file == null || !file.canRead()) {
            throw new Exception("cli.error.cannot_read_file");
        }

        List<Artifact> artifacts = new ArrayList<Artifact>();
        parseFile(file, artifacts);
        System.out.println("Found " + artifacts.size() + " artifacts");
    }

    private void parseFile(File file, List<Artifact> artifacts) throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(file));

        if (jsonObject.containsKey(JSON_TAG_ARTIFACTS)) {
            JSONArray jsonArray = (JSONArray) jsonObject.get(JSON_TAG_ARTIFACTS);

            Iterator<JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                artifacts.add(new Artifact(iterator.next()));
            }
        }
    }



}

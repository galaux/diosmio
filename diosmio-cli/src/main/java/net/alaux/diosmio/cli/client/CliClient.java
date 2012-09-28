package net.alaux.diosmio.cli.client;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import net.alaux.diosmio.cli.Main;
import net.alaux.diosmio.com.entity.Artifact;
import net.alaux.diosmio.com.entity.impl.HostConfig;
import net.alaux.diosmio.com.service.ArtifactService;
import net.alaux.diosmio.com.service.HostConfigService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public abstract class CliClient {

    private static final String JSON_TAG_ARTIFACTS = "artifacts";
    private static final String JSON_TAG_HOST_CONFIGS = "host_configs";

    protected ArtifactService artifactService;
    protected HostConfigService hostConfigService;

    public abstract ArtifactService getArtifactService();

    public abstract HostConfigService getHostConfigService();

    public abstract void close();

    // Artifact ***************************************************************

    public void listAllArtifacts() {

	List<Artifact> artifacts = null;
	try {
	    artifacts = getArtifactService().getAll();
	} catch (RemoteException e) {
	    throw new RuntimeException(
		    Main.bundle.getString("error.server_connection"), e);
	}

	for (Artifact artifact : artifacts) {
	    Main.out.println(artifact);
	}
    }

    public void showArtifact(Long id) {

	Artifact artifact = null;
	try {
	    artifact = getArtifactService().get(id);
	} catch (RemoteException e) {
	    throw new RuntimeException(
		    Main.bundle.getString("error.server_connection"), e);
	}
	if (artifact != null) {
	    Main.out.println(artifact);
	} else {
	    Main.out.println(Main.bundle.getString("info.artifact.not_found"));
	}
    }

    private void doCreateArtifact(File file) {

	Main.logger.info("Creating artifact " + file.getName());

	try {
	    FileInputStream fis = new FileInputStream(file);

	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    byte[] buf = new byte[1024];
	    for (int readNum; (readNum = fis.read(buf)) != -1;) {
		bos.write(buf, 0, readNum);
	    }

	    Artifact artifact = new Artifact();
	    artifact.setName(file.getName());
	    getArtifactService().create(artifact, bos.toByteArray());

	    fis.close();

	} catch (FileNotFoundException e) {
	    throw new RuntimeException(MessageFormat.format(
		    Main.bundle.getString("error.access.read"),
		    file.getAbsolutePath()), e);
	} catch (IOException e) {
	    throw new RuntimeException(MessageFormat.format(
		    Main.bundle.getString("error.access.read"),
		    file.getAbsolutePath()), e);
	}
    }

    public void createArtifact(File file) {

	if (!file.exists() || !file.canRead()) {
	    throw new RuntimeException(MessageFormat.format(
		    Main.bundle.getString("error.access.read"),
		    file.getAbsoluteFile()));
	}

	if (file.isFile()) {
	    doCreateArtifact(file);
	} else {
	    Main.logger.info("Scanning for files in " + file.getAbsolutePath()
		    + ".");
	    List<File> files = getFilesOfExtension(file, "war");
	    Main.logger.info(" Found " + files.size());
	    for (File f : files) {
		try {
		    doCreateArtifact(f);

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
	    @Override
	    public boolean accept(File file, String s) {
		return s.endsWith(fullExtension);
	    }
	});

	if (files != null) {
	    resultList.addAll(Arrays.asList(files));
	}

	File[] dirs = dir.listFiles(new FileFilter() {
	    @Override
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

	try {
	    getArtifactService().delete(id);
	    Main.out.println(Main.bundle.getString("info.artifact.deleted"));
	} catch (RemoteException e) {
	    throw new RuntimeException(
		    Main.bundle.getString("error.server_connection"), e);
	}
    }

    // Configuration **********************************************************

    public void createConfiguration(String sshUser, String hostname,
	    String sshPort) {
	try {
	    getHostConfigService().create(
		    new HostConfig(hostname, sshPort, sshUser));
	} catch (RemoteException e) {
	    throw new RuntimeException(
		    Main.bundle.getString("error.server_connection"), e);
	}
    }

    public void readConfiguration(Long id) {
	Main.logger.info("readConfiguration(" + id + ")");
	try {
	    Main.out.println(getHostConfigService().get(id));
	} catch (RemoteException e) {
	    throw new RuntimeException(
		    Main.bundle.getString("error.server_connection"), e);
	}
    }

    public void listAllConfigurations() {

	Main.logger.info("listAllConfigurations()");
	List<HostConfig> hostConfigs = null;
	try {
	    hostConfigs = getHostConfigService().getAll();

	    for (HostConfig hostConfig : hostConfigs) {
		Main.out.println((hostConfig).toString());
	    }
	} catch (RemoteException e) {
	    throw new RuntimeException(
		    Main.bundle.getString("error.server_connection"), e);
	}
    }

    public void deleteConfiguration(Long id) {

	try {
	    getHostConfigService().delete(id);
	    Main.out.println(Main.bundle
		    .getString("info.configuration.deleted"));
	} catch (RemoteException e) {
	    throw new RuntimeException(
		    Main.bundle.getString("error.server_connection"), e);
	}
    }

    // Automatic loading ******************************************************

    public void loadFile(File file) {

	if (!file.canRead()) {
	    throw new RuntimeException(MessageFormat.format(
		    Main.bundle.getString("cli.error.cannot_read_file"),
		    file.getAbsoluteFile()));
	}

	List<Artifact> artifacts = new ArrayList<Artifact>();
	List<HostConfig> hostConfigs = new ArrayList<HostConfig>();
	parseFile(file, artifacts, hostConfigs);
	for (HostConfig hostConfig : hostConfigs) {
	    try {
		getHostConfigService().create(hostConfig);
	    } catch (RemoteException e) {
		// TOOD add error message
		throw new RuntimeException(e);
	    }
	}
	Main.out.println("Not yet persisting Artifacts. TODO?");
    }

    public void parseFile(File file) {

	Main.logger.info("parseFile");
	if (!file.canRead()) {
	    throw new RuntimeException(MessageFormat.format(
		    Main.bundle.getString("cli.error.cannot_read_file"),
		    file.getAbsoluteFile()));
	}

	List<Artifact> artifacts = new ArrayList<Artifact>();
	List<HostConfig> hostConfigs = new ArrayList<HostConfig>();
	parseFile(file, artifacts, hostConfigs);
	Main.out.println(MessageFormat.format(
		Main.bundle.getString("info.artifacts.found"), artifacts.size()));
	Main.out.println(MessageFormat.format(
		Main.bundle.getString("info.host_configs.found"),
		hostConfigs.size()));
    }

    private void parseFile(File file, List<Artifact> artifacts,
	    List<HostConfig> hostConfigs) {

	try {
	    JSONParser parser = new JSONParser();
	    JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(
		    file));

	    if (jsonObject.containsKey(JSON_TAG_ARTIFACTS)) {
		JSONArray jsonArray = (JSONArray) jsonObject
			.get(JSON_TAG_ARTIFACTS);

		Iterator<JSONObject> iterator = jsonArray.iterator();
		while (iterator.hasNext()) {
		    artifacts.add(new Artifact(iterator.next()));
		}
	    }

	    if (jsonObject.containsKey(JSON_TAG_HOST_CONFIGS)) {
		JSONArray jsonArray = (JSONArray) jsonObject
			.get(JSON_TAG_HOST_CONFIGS);

		Iterator<JSONObject> iterator = jsonArray.iterator();
		while (iterator.hasNext()) {
		    hostConfigs.add(new HostConfig(iterator.next()));
		}
	    }

	} catch (IOException e) {
	    throw new RuntimeException(MessageFormat.format(
		    Main.bundle.getString("cli.error.cannot_read_file"),
		    file.getAbsolutePath()));
	} catch (ParseException e) {
	    throw new RuntimeException(MessageFormat.format(
		    Main.bundle.getString("error.json.parse"),
		    file.getAbsolutePath()));
	}
    }
}

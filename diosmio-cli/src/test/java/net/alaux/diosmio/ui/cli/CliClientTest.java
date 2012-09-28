package net.alaux.diosmio.ui.cli;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import junit.framework.Assert;
import net.alaux.diosmio.cli.Main;
import net.alaux.diosmio.cli.client.CliClient;
import net.alaux.diosmio.com.service.ArtifactService;
import net.alaux.diosmio.com.service.HostConfigService;

import org.junit.Test;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net> Date: 9/5/12
 */
public class CliClientTest {

    // Main main = new Main(new String[] {});
    private class MainMock extends Main {

	public MainMock(String[] args) {
	    super(args);
	    this.out = new PrintWriter(new ByteArrayOutputStream());
	}

    }

    CliClient testedClient = new CliClient() {
	@Override
	public ArtifactService getArtifactService() {
	    // Nothing to do
	    return null;
	}

	@Override
	public HostConfigService getHostConfigService() {
	    // Nothing to do
	    return null;
	}

	@Override
	public void close() {
	    // Nothing to do
	}
    };

    // @Before
    // public void before() {
    //
    // }

    @Test
    public void testListAllArtifacts() {

	MainMock main = new MainMock(new String[] {});

	testedClient.listAllArtifacts();

	Assert.assertEquals("", main.out.toString());
    }

    // public void testShowArtifact() {
    //
    // }
    //
    // public void testCreateArtifact() {
    //
    // }
    //
    // public void testCreateArtifact() {
    //
    // }
    //
    // public void testGetFilesOfExtension() {
    //
    // }
    //
    // public void testDeleteArtifact() {
    //
    // }
    //
    // public void testCreateConfiguration() {
    //
    // }
    //
    // public void testReadConfiguration() {
    //
    // }
    //
    // public void testListAllConfigurations() {
    //
    // }
    //
    // public void testLoadFile() {
    //
    // }
    //
    // public void testParseFile() {
    //
    // }
    //
    // public void testParseFile() {
    //
    // }

}

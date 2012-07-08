package net.alaux.diosmio.core.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public interface IArtifactManager {

	void addArtifact(String name, byte[] content) throws Exception;

	File[] listArtifacts();

	FileOutputStream getArtifact(String id);

	boolean deleteArtifact(String artifactId) throws Exception;
}

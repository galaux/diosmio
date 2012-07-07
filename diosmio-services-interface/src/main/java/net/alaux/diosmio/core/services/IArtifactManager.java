package net.alaux.diosmio.core.services;

import java.io.File;
import java.io.FileOutputStream;

public interface IArtifactManager {

	void addArtifact(File file) throws Exception;

	File[] listArtifacts();

	FileOutputStream getArtifact(String id);

	boolean deleteArtifact(File file) throws Exception;
}

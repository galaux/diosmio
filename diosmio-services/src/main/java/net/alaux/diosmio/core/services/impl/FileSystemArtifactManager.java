package net.alaux.diosmio.core.services.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import net.alaux.diosmio.core.services.IArtifactManager;
import net.alaux.diosmio.utils.DiosMioUtils;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FileSystemArtifactManager implements IArtifactManager {

	private static final String STORE_DIRECTORY_PATH = "/home/miguel/documents/it/diosmios/4/storage";
	private static final String FILE_SEPARATOR = System
			.getProperty("file.separator");

	private static File storageDirectory;

	public FileSystemArtifactManager() throws IOException {
		storageDirectory = new File(STORE_DIRECTORY_PATH);
		if (!storageDirectory.exists() || !storageDirectory.canRead()
				|| !storageDirectory.isDirectory()) {
			throw new IOException("error.storage_dir_not_accessible");
		}
	}


	public void addArtifact(File file) throws Exception {
		// No check (yet?). Should we do this here or on the presentation side?

		if (file == null || !file.canRead()) {
			throw new Exception("error.file_not_readable");
		}

		String destFilePath = storageDirectory.getAbsolutePath()
				+ FILE_SEPARATOR + file.getName();

		File destFile = new File(destFilePath);

		if (destFile == null || destFile.exists()) {
			throw new Exception("error.file_already_exists");
		}

		DiosMioUtils.copyFile(file, destFile);
	}

	public File[] listArtifacts() {
		return storageDirectory.listFiles();
	}

	public FileOutputStream getArtifact(String id) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	public boolean deleteArtifact(File file) throws Exception {
		if (file == null || !file.exists()) {
			throw new Exception("error.file_not_readable");
		}

		return file.delete();
	}

}

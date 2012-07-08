package net.alaux.diosmio.core.services.impl;

import java.io.*;

import net.alaux.diosmio.core.services.IArtifactManager;
import net.alaux.diosmio.utils.DiosMioUtils;
import sun.misc.IOUtils;
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


	public void addArtifact(String name, byte[] content) throws Exception {

        File artifact = new File(STORE_DIRECTORY_PATH + FILE_SEPARATOR + name);

		if (artifact == null || artifact.exists()) {
			throw new Exception("error.file_already_exists");
		}

        FileOutputStream fos = new FileOutputStream(artifact);
        try {
            fos.write(content);
        } finally {
            fos.flush();
            fos.close();
        }
	}

        // TODO remove this static method as it is not used anymore
//		DiosMioUtils.copyFile(file, destFile);


	public File[] listArtifacts() {
		return storageDirectory.listFiles();
	}

	public FileOutputStream getArtifact(String id) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	public boolean deleteArtifact(String artifactId) throws Exception {

        File file = new File(STORE_DIRECTORY_PATH + FILE_SEPARATOR + artifactId);

		if (file == null || !file.exists() || !file.canWrite()) {
			throw new Exception("error.file_not_readable");
		}

		return file.delete();
	}

}

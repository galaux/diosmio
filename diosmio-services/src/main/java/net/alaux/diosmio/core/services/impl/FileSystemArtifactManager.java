package net.alaux.diosmio.core.services.impl;

import java.io.*;
import java.util.Properties;

import net.alaux.diosmio.DiosMioGenericService;
import net.alaux.diosmio.core.services.IArtifactManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class FileSystemArtifactManager extends DiosMioGenericService implements IArtifactManager  {

    private final String STORAGE_DIR_PATH = serviceProperties.getProperty("server.store.directory.path");

    private static final String FILE_SEPARATOR = System.getProperty("file.separator");

    private static File storageDirectory;

    public static final Logger logger = LoggerFactory.getLogger(FileSystemArtifactManager.class);

    /**
     *
     * @param serviceProperties
     * @throws IOException
     */
    public FileSystemArtifactManager(Properties serviceProperties) throws IOException {

        super(serviceProperties);

        storageDirectory = new File(STORAGE_DIR_PATH);
        if (storageDirectory == null || !storageDirectory.exists() || !storageDirectory.canRead()
                || !storageDirectory.isDirectory()) {
            throw new IOException("error.storage_dir_not_accessible");
        }
    }

    /**
     *
     * @param name
     * @param content
     * @throws Exception
     */
    public void addArtifact(String name, byte[] content) throws Exception {

        File artifact = new File(STORAGE_DIR_PATH + FILE_SEPARATOR + name);

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


    /**
     *
     * @return
     */
    public File[] listArtifacts() {
        return storageDirectory.listFiles();
    }

    /**
     *
     * @param id
     * @return
     */
    public FileOutputStream getArtifact(String id) {
        // TODO Auto-generated method stub
        throw new NotImplementedException();
    }

    /**
     *
     * @param artifactId
     * @return
     * @throws IOException
     */
    public boolean deleteArtifact(String artifactId) throws IOException {

        File file = new File(STORAGE_DIR_PATH + FILE_SEPARATOR + artifactId);

        if (file == null || !file.exists() || !file.canWrite()) {
            throw new IOException("error.file_not_readable");
        }

        return file.delete();
    }

}

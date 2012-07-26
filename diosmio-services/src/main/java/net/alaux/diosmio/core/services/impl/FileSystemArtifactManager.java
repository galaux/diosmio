package net.alaux.diosmio.core.services.impl;

import java.io.*;

import net.alaux.diosmio.core.persistence.dao.impl.CassandraEmDao;
import net.alaux.diosmio.core.persistence.entity.Artifact;
import net.alaux.diosmio.server.common.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;


public class FileSystemArtifactManager {

    @Autowired
//    @Qualifier("appProps")
    public AppProperties appProps;

    private File storageDirectory;

    private CassandraEmDao dao;

    public static final Logger logger = LoggerFactory.getLogger(FileSystemArtifactManager.class);

    @PostConstruct
    public void init() throws IOException {

        storageDirectory = new File(appProps.storageDirPath);
        if (storageDirectory == null || !storageDirectory.exists() || !storageDirectory.canRead()
                || !storageDirectory.isDirectory()) {
            throw new IOException("error.storage_dir_not_accessible");
        }

        dao = new CassandraEmDao();
    }

    /**
     *
     * @param name
     * @param content
     * @throws Exception
     */
    public void addArtifact(String name, byte[] content) throws Exception {

        File file = new File(appProps.storageDirPath + appProps.FILE_SEPARATOR + name);

        if (file == null || file.exists()) {
            throw new Exception("error.file_already_exists");
        }

        FileOutputStream fos = new FileOutputStream(file);
        try {
            fos.write(content);
        } finally {
            fos.flush();
            fos.close();
        }

        Artifact artifact = new Artifact(name, "/");
        dao.create(artifact);
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

        File file = new File(appProps.storageDirPath + appProps.FILE_SEPARATOR + artifactId);

        if (file == null || !file.exists() || !file.canWrite()) {
            throw new IOException("error.file_not_readable");
        }

        return file.delete();
    }

}

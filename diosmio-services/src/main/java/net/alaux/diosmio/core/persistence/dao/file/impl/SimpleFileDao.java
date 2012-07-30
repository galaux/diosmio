package net.alaux.diosmio.core.persistence.dao.file.impl;

import java.io.*;
import java.io.File;

import net.alaux.diosmio.core.persistence.dao.file.FileDao;
import net.alaux.diosmio.server.common.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;


public class SimpleFileDao implements FileDao {

    @Autowired
    public AppProperties appProps;

    private File storageDirectory;

    public static final Logger logger = LoggerFactory.getLogger(SimpleFileDao.class);

    @PostConstruct
    public void init() throws IOException {

        storageDirectory = new java.io.File(appProps.storageDirPath);
        if (storageDirectory == null || !storageDirectory.exists() || !storageDirectory.canRead()
                || !storageDirectory.isDirectory()) {
            throw new IOException("error.storage_dir_not_accessible");
        }
    }

    public boolean getStatus() {
        return (storageDirectory != null) && (storageDirectory.exists()) && (storageDirectory.canRead())
                && (storageDirectory.isDirectory());
    }

    /**
     *
     * @param internPath
     * @param content
     * @throws Exception
     */
    public void create(String internPath, byte[] content) throws Exception {

        java.io.File file = new java.io.File(appProps.storageDirPath + appProps.FILE_SEPARATOR + internPath);

        if (file == null || file.exists()) {
            throw new Exception("error.file_already_exists");
        }

        // TODO handle internPath = dir + filename
        FileOutputStream fos = new FileOutputStream(file);
        try {
            fos.write(content);
        } finally {
            fos.flush();
            fos.close();
        }
    }

    /**
     *
     * @param internPath
     * @return
     */
    public File get(String internPath) {
        return new File(internPath);
    }

    /**
     *
     * @param internPath
     * @return
     * @throws IOException
     */
    public boolean delete(String internPath) throws IOException {

        java.io.File file = new java.io.File(appProps.storageDirPath + appProps.FILE_SEPARATOR + internPath);

        if (file == null || !file.exists() || !file.canWrite()) {
            throw new IOException("error.file_not_readable");
        }

        return file.delete();
    }

}

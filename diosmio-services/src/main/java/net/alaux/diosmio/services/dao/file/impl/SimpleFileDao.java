package net.alaux.diosmio.services.dao.file.impl;



import net.alaux.diosmio.common.AppProperties;
import net.alaux.diosmio.services.dao.file.FileDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class SimpleFileDao implements FileDao {

    @Autowired
    public AppProperties appProps;

    private File storageDirectory;

    public Log logger = LogFactory.getLog(SimpleFileDao.class);

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

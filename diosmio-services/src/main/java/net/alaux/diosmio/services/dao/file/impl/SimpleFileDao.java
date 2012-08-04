package net.alaux.diosmio.services.dao.file.impl;


import net.alaux.diosmio.services.AppMessages;
import net.alaux.diosmio.services.dao.file.FileDao;
import net.alaux.utils.AppException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class SimpleFileDao implements FileDao {

    private File storageDirectory;

    public Log logger = LogFactory.getLog(SimpleFileDao.class);

    @Autowired
    private AppMessages diosMioMessage;

    public static final String FILE_SEPARATOR   = System.getProperty("file.separator");

    @Value("${server.store.directory.path}")
    public String storageDirPath;

    @PostConstruct
    public void init() throws AppException {

        storageDirectory = new java.io.File(storageDirPath);
        if (storageDirectory == null
                || !storageDirectory.exists()
                || !storageDirectory.canRead()
                || !storageDirectory.isDirectory()) {
            throw new AppException(
                    diosMioMessage.get("error.storage_dir_not_accessible", storageDirPath)
            );
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
     * @throws net.alaux.utils.AppException
     * @throws IOException
     */
    public void create(String internPath, byte[] content) throws AppException, IOException {

        java.io.File file = new java.io.File(storageDirPath + FILE_SEPARATOR + internPath);

        if (file == null || file.exists()) {
            throw new AppException(
                    diosMioMessage.get("error.file_already_exists",storageDirPath + FILE_SEPARATOR + internPath)
            );
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
     * @throws net.alaux.utils.AppException
     */
    public boolean delete(String internPath) throws AppException {

        java.io.File file = new java.io.File(storageDirPath + FILE_SEPARATOR + internPath);

        if (file == null || !file.exists() || !file.canWrite()) {
            throw new AppException(
                    diosMioMessage.get("error.file_not_readable", storageDirPath + FILE_SEPARATOR + internPath)
            );
        }

        return file.delete();
    }

}

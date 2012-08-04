package net.alaux.diosmio.services.dao.file.impl;


import net.alaux.utils.AppException;
import net.alaux.utils.AppProperties;
import net.alaux.diosmio.services.AppMessages;
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

    @Autowired
    private AppMessages diosMioMessage;

    @PostConstruct
    public void init() throws AppException {

        storageDirectory = new java.io.File(appProps.storageDirPath);
        if (storageDirectory == null
                || !storageDirectory.exists()
                || !storageDirectory.canRead()
                || !storageDirectory.isDirectory()) {
            throw new AppException(
                    diosMioMessage.get("error.storage_dir_not_accessible",
                            appProps.storageDirPath)
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

        java.io.File file = new java.io.File(appProps.storageDirPath + appProps.FILE_SEPARATOR + internPath);

        if (file == null || file.exists()) {
            throw new AppException(
                    diosMioMessage.get("error.file_already_exists",
                            appProps.storageDirPath + appProps.FILE_SEPARATOR + internPath)
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

        java.io.File file = new java.io.File(appProps.storageDirPath + appProps.FILE_SEPARATOR + internPath);

        if (file == null || !file.exists() || !file.canWrite()) {
            throw new AppException(
                    diosMioMessage.get("error.file_not_readable",
                            appProps.storageDirPath + appProps.FILE_SEPARATOR + internPath)
            );
        }

        return file.delete();
    }

}

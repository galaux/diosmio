package net.alaux.diosmio.services.dao.file.impl;


import net.alaux.diosmio.services.AppMessages;
import net.alaux.diosmio.services.dao.file.FileDao;
import net.alaux.diosmio.services.entity.Artifact;
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

    public File storageDirectory;

    public Log logger = LogFactory.getLog(SimpleFileDao.class);

    @Autowired
    private AppMessages diosMioMessage;

    public static final String FILE_SEPARATOR   = System.getProperty("file.separator");

    @Value("${server.store.directory.path}")
    public String storageDirPath;

    private String getInnerPathName(Artifact artifact) {
        return storageDirPath + FILE_SEPARATOR + artifact.getId() + "_" + artifact.getName();
    }

    @PostConstruct
    public void init() throws AppException {

        storageDirectory = new File(storageDirPath);
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
     * @param artifact
     * @param content
     * @throws net.alaux.utils.AppException
     * @throws IOException
     */
    public void create(Artifact artifact, byte[] content) throws AppException, IOException {

        File file = new File(getInnerPathName(artifact));

        if (file == null || file.exists()) {
            throw new AppException(
                    diosMioMessage.get("error.file_already_exists", getInnerPathName(artifact))
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

    public File get(Artifact artifact) {
        return new File(getInnerPathName(artifact));
    }

    public boolean delete(Artifact artifact) throws AppException {

        File file = new File(getInnerPathName(artifact));

        if (file == null || !file.exists() || !file.canWrite()) {
            throw new AppException(
                    diosMioMessage.get("error.file_not_readable", getInnerPathName(artifact))
            );
        }

        return file.delete();
    }

}

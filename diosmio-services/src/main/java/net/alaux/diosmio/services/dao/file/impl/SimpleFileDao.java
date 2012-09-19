package net.alaux.diosmio.services.dao.file.impl;


import net.alaux.diosmio.services.dao.file.FileDao;
import net.alaux.diosmio.services.entity.Artifact;
import net.alaux.utils.AppMessages;
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
    private AppMessages appMessages;

    public static final String FILE_SEPARATOR   = System.getProperty("file.separator");

    @Value("${server.store.directory.path}")
    public String storageDirPath;

    private String getInnerPathName(Artifact artifact) {
        return storageDirPath + FILE_SEPARATOR + artifact.getId() + "_" + artifact.getName();
    }

    @PostConstruct
    public void init() {

        storageDirectory = new File(storageDirPath);
        if (storageDirectory == null
                || !storageDirectory.exists()
                || !storageDirectory.canRead()
                || !storageDirectory.isDirectory()) {
            throw new RuntimeException(
                    appMessages.get("error.storage_dir_not_accessible", storageDirPath)
            );
        }
    }

    public void create(Artifact artifact, byte[] content) {

        File file = new File(getInnerPathName(artifact));

        if (file == null || file.exists()) {
            throw new RuntimeException(
                    appMessages.get("error.file_already_exists", getInnerPathName(artifact))
            );
        }

        try {
            // TODO handle internPath = dir + filename
            FileOutputStream fos = new FileOutputStream(file);
            try {
                fos.write(content);
            } finally {
                fos.flush();
                fos.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File get(Artifact artifact) {
        return new File(getInnerPathName(artifact));
    }

    public boolean delete(Artifact artifact) {

        File file = new File(getInnerPathName(artifact));

        if (file == null || !file.exists() || !file.canWrite()) {
            throw new RuntimeException(
                    appMessages.get("error.file_not_readable", getInnerPathName(artifact))
            );
        }

        return file.delete();
    }

}

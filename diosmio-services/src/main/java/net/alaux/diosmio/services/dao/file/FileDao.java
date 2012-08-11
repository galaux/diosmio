package net.alaux.diosmio.services.dao.file;

import net.alaux.diosmio.services.entity.Artifact;
import net.alaux.utils.AppException;

import java.io.File;
import java.io.IOException;

public interface FileDao {

    public boolean getStatus();

    public void create(Artifact artifact, byte[] content) throws AppException, IOException;

	File get(Artifact artifact);

	boolean delete(Artifact artifact) throws AppException;
}

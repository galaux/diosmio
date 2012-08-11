package net.alaux.diosmio.services.dao.file;

import net.alaux.utils.AppException;

import java.io.File;
import java.io.IOException;

public interface FileDao {

    public boolean getStatus();

    public void create(String name, byte[] content) throws AppException, IOException;

	File get(String internPath);

	boolean delete(String internPath) throws AppException;

    boolean exists(String internPath);
}

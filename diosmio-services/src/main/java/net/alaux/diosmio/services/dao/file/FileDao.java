package net.alaux.diosmio.services.dao.file;

import java.io.File;

public interface FileDao {

    public boolean getStatus();

	void create(String internPath, byte[] content) throws Exception;

	File get(String internPath);

//    File[] getAll();

	boolean delete(String internPath) throws Exception;
}

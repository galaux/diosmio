package net.alaux.diosmio.core.persistence.dao.file;

import java.io.File;

public interface FileDao {

	void create(String internPath, byte[] content) throws Exception;

	File get(String internPath);

//    File[] getAll();

	boolean delete(String internPath) throws Exception;
}

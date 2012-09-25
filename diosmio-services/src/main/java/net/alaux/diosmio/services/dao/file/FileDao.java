package net.alaux.diosmio.services.dao.file;

import java.io.File;

import net.alaux.diosmio.com.entity.Artifact;

/*
 * TODO Should this class only accept File and byte[]?
 */
public interface FileDao {

    public void create(Artifact artifact, byte[] content);

    File get(Artifact artifact);

    boolean delete(Artifact artifact);
}

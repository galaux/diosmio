package net.alaux.diosmio.services.dao.file;

import net.alaux.diosmio.services.entity.Artifact;

import java.io.File;

public interface FileDao {

    public void create(Artifact artifact, byte[] content);

	File get(Artifact artifact);

	boolean delete(Artifact artifact);
}

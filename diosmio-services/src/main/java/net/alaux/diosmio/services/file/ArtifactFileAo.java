package net.alaux.diosmio.services.file;

import java.io.File;

import net.alaux.diosmio.com.entity.Artifact;

public interface ArtifactFileAo {

    public void create(Artifact artifact, byte[] content);

    File get(Artifact artifact);

    boolean delete(Artifact artifact);
}

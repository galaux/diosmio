package net.alaux.diosmio.core.service;

import net.alaux.diosmio.core.entity.Artifact;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/26/12
 * Time: 10:39 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ArtifactManager {

    Artifact create(String internPath, byte[] content) throws Exception;

    Artifact get(UUID id);

    Artifact[] getAll();

    boolean delete(UUID id) throws Exception;
}

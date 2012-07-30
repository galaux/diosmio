package net.alaux.diosmio.core.service;

import net.alaux.diosmio.core.entity.Artifact;
import net.alaux.diosmio.core.persistence.dao.db.DatabaseDao;
import net.alaux.diosmio.core.persistence.dao.file.FileDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/26/12
 * Time: 10:39 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ArtifactManager {

    public boolean getStatus();

    Artifact create(String internPath, byte[] content) throws Exception;

    Artifact get(Long id);

    List<Artifact> getAll();

    boolean delete(Long id) throws Exception;
}

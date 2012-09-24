package net.alaux.diosmio.com;

import java.util.List;

import net.alaux.diosmio.com.protobuf.proto.DiosmioEntityProtos.ArtifactPB;
import net.alaux.diosmio.services.entity.Artifact;

public interface AbstractArtifactManager {

    public ArtifactPB create(String name, byte[] content);

    public ArtifactPB create(ArtifactPB artifact);

    public Artifact get(Long id);

    public List<ArtifactPB> getAll();

    public void delete(ArtifactPB artifact);

    public void delete(Long id);

    public List<Long> delete(List<Long> ids);

    public ArtifactPB update(ArtifactPB artifact);
}

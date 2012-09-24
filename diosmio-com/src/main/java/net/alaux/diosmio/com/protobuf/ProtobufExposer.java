package net.alaux.diosmio.com.protobuf;

import java.util.List;

import net.alaux.diosmio.com.AbstractArtifactManager;
import net.alaux.diosmio.com.protobuf.proto.DiosmioEntityProtos.ArtifactPB;
import net.alaux.diosmio.services.core.ArtifactManager;
import net.alaux.diosmio.services.entity.Artifact;

import org.springframework.beans.factory.annotation.Autowired;

public class ProtobufExposer implements AbstractArtifactManager {

    @Autowired
    ArtifactManager artifactManager;

    @Override
    public ArtifactPB create(String name, byte[] content) {

	return null;

	// Artifact artifact = artifactManager.create(name, content);
	//
	// ArtifactPB.Builder artifactBuilder = ArtifactPB.newBuilder();
	//
	// return ArtifactPB.newBuilder().setId(artifact.getId())
	// .setName(artifact.getName()).build();
    }

    @Override
    public ArtifactPB create(ArtifactPB artifact) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Artifact get(Long id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<ArtifactPB> getAll() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void delete(ArtifactPB artifact) {
	// TODO Auto-generated method stub

    }

    @Override
    public void delete(Long id) {
	// TODO Auto-generated method stub

    }

    @Override
    public List<Long> delete(List<Long> ids) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public ArtifactPB update(ArtifactPB artifact) {
	// TODO Auto-generated method stub
	return null;
    }

}

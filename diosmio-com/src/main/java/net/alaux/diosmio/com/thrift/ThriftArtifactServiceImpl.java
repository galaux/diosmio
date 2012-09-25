package net.alaux.diosmio.com.thrift;

import net.alaux.diosmio.com.entity.Artifact;

public class ThriftArtifactServiceImpl
// implements ThriftArtifactService.Iface
{

    // @Autowired
    // ArtifactManager artifactManager;
    //
    // @Override
    // public ThriftArtifact create(ThriftArtifact thrift) throws TException {
    // return getThrift(artifactManager.create(getEntity(thrift)));
    // }
    //
    // @Override
    // public ThriftArtifact get(long id) throws TException {
    // return getThrift(artifactManager.get(id));
    // }
    //
    // @Override
    // public List<ThriftArtifact> getAll() throws TException {
    // List<Artifact> artifacts = artifactManager.getAll();
    // List<ThriftArtifact> thrifts = new ArrayList<ThriftArtifact>(
    // artifacts.size());
    //
    // for (Artifact entity : artifacts) {
    // thrifts.add(getThrift(entity));
    // }
    // return thrifts;
    // }
    //
    // @Override
    // public void deleteArtifact(ThriftArtifact thrift) throws TException {
    // artifactManager.delete(getEntity(thrift));
    // }
    //
    // @Override
    // public void deleteArtifactById(long id) throws TException {
    // artifactManager.delete(id);
    // }
    //
    // @Override
    // public List<Long> deleteArtifacts(List<Long> ids) throws TException {
    // return artifactManager.delete(ids);
    // }
    //
    // @Override
    // public ThriftArtifact update(ThriftArtifact thrift) throws TException {
    // return getThrift(artifactManager.update(getEntity(thrift)));
    // }

    // ******************************************

    private ThriftArtifact getThrift(Artifact entity) {
	ThriftArtifact thrift = new ThriftArtifact(entity.getName());
	thrift.setId(entity.getId());
	return thrift;
    }

    private Artifact getEntity(ThriftArtifact thrift) {
	Artifact entity = new Artifact(thrift.getId(), thrift.getName());
	return entity;
    }
}

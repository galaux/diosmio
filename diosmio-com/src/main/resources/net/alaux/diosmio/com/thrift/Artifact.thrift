namespace java net.alaux.diosmio.com.thrift

struct ThriftArtifact {
  1: optional i64 id,
  2: string name
}

service ThriftArtifactService {
//     ThriftArtifact create(1: string name, byte[] content), 
     ThriftArtifact create(1: ThriftArtifact thrift),
     ThriftArtifact get(1: i64 id),
     list<ThriftArtifact> getAll(),
     void deleteArtifact(1: ThriftArtifact thrift),
     void deleteArtifactById(1: i64 id),
     list<i64> deleteArtifacts(1: list<i64> ids),
     ThriftArtifact update(1: ThriftArtifact thrift)
}
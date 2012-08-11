package net.alaux.diosmio.ui.cli.jmxcli.actions;

public class CliArtifactManagerJmxActions extends CliJmxActions {

    // TODO Remove if unused

//    public CliArtifactManagerJmxActions(String jmxUrl, String domainName) throws IOException{
//        super(jmxUrl, domainName);
//    }
//
//    // TODO handle Exception
//    public void create(String arg) throws IOException, InstanceNotFoundException, MalformedObjectNameException, Exception {
//
//        ArtifactManager artifactManager = getServiceBean(ArtifactManager.class);
//
//        File artifactFile = new File(arg);
//        if (artifactFile == null || !artifactFile.canRead()) {
//            throw new Exception("cli.error.cannot_read_file");
//        }
//
//        FileInputStream fis = new FileInputStream(artifactFile);
//
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        byte[] buf = new byte[1024];
//        for (int readNum; (readNum = fis.read(buf)) != -1;) {
//            bos.write(buf, 0, readNum);
//        }
//
//        artifactManager.create(artifactFile.getName(), bos.toByteArray());
//    }
//
//    public void showArtifact(Long id) throws IOException, InstanceNotFoundException, MalformedObjectNameException {
//
//        ArtifactManager artifactManager = getServiceBean(ArtifactManager.class);
//        Artifact artifact = artifactManager.get(id);
//        if (artifact != null) {
//            System.out.println(artifact);
//        } else {
//            System.out.println("Artifact not found");
//        }
//    }
//
//    public void listAllArtifacts() throws IOException, InstanceNotFoundException, MalformedObjectNameException {
//
//        ArtifactManager artifactManager = getServiceBean(ArtifactManager.class);
//
//        List<Artifact> artifacts = artifactManager.getAll();
//
//        for (Artifact artifact : artifacts) {
//            System.out.println(artifact);
//        }
//    }
//
//    /**
//     *
//     * @param id
//     * @throws IOException
//     * @throws InstanceNotFoundException
//     * @throws MalformedObjectNameException
//     * @throws Exception
//     */
//    // TODO handle "Exception" as BusinessExceptin
//    public void delete(Long id) throws IOException, InstanceNotFoundException, MalformedObjectNameException, Exception  {
//
//        ArtifactManager artifactManager = getServiceBean(ArtifactManager.class);
//        Artifact artifact = artifactManager.get(id);
//
//        if (artifact == null) {
//            System.out.println("Cannot find artifact");
//        } else {
//            artifactManager.delete(artifact);
//            System.out.println("Artifact deleted");
//        }
//    }
}

package net.alaux.diosmio.ui.cli;

public interface DiosMioCli {

    void listAllArtifacts();
    void showArtifact(Long id);
    void createArtifact(String path);
    void deleteArtifact(Long id);

    void loadFile(String filePath);
    void parseFile(String filePath);

    public void createConfiguration(String hostname, String sshPort, String sshUser);
    public void readConfiguration(Long id);
    public void listAllConfigurations();
}

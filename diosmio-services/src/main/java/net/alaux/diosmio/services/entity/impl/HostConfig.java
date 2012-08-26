package net.alaux.diosmio.services.entity.impl;

import org.hibernate.annotations.GenericGenerator;
import org.json.simple.JSONObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net>
 * Date: 8/11/12
 */
@Entity
//@Table(name = "HOSTCONFIG")
public class HostConfig implements Serializable {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    private String hostname;

    private String sshPort;

    private String sshUser;

    // For now, let's rely on automatic public/private key authentication

    public HostConfig() {
    }

    public HostConfig(String hostname, String sshPort, String sshUser) {
        this.hostname = hostname;
        this.sshPort = sshPort;
        this.sshUser = sshUser;
    }

    public HostConfig(JSONObject jsonObject) {
        this.hostname = (String) jsonObject.get("hostname");
        this.sshPort = (String) jsonObject.get("sshPort");
        this.sshUser = (String) jsonObject.get("sshUser");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " - id=" + id + ", " + sshUser + "@" + hostname + ":" + sshPort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getSshPort() {
        return sshPort;
    }

    public void setSshPort(String sshPort) {
        this.sshPort = sshPort;
    }

    public String getSshUser() {
        return sshUser;
    }

    public void setSshUser(String sshUser) {
        this.sshUser = sshUser;
    }
}

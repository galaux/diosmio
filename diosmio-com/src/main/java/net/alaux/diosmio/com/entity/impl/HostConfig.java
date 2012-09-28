package net.alaux.diosmio.com.entity.impl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.json.simple.JSONObject;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net> Date: 8/11/12
 */
@Entity
@Table(name = "HOST_CONFIG")
@NamedQueries({
	@NamedQuery(name = HostConfig.Q_FIND_ALL, query = HostConfig.Q_FIND_ALL),
	@NamedQuery(name = HostConfig.Q_DELETE_BY_ID, query = HostConfig.Q_DELETE_BY_ID) //
})
public class HostConfig implements Serializable {

    public static final String Q_FIND_ALL = "SELECT hc from HostConfig hc";
    public static final String Q_DELETE_BY_ID = "DELETE FROM HostConfig hc WHERE hc.id = :id";

    @Id
    @GeneratedValue
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
	return id + "\t" + sshUser + "@" + hostname + ":" + sshPort;
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

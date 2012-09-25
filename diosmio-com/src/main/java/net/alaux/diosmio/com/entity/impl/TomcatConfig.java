package net.alaux.diosmio.com.entity.impl;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import net.alaux.diosmio.com.entity.Configuration;

/**
 * @author Guillaume ALAUX <guillaume at alaux dot net> Date: 8/11/12
 */
@Entity
@Table(name = TomcatConfig.TABLE_NAME)
public class TomcatConfig implements Configuration {

    public static final String TABLE_NAME = "TOMCAT_CONFIG";

    @Id
    @GeneratedValue
    private Long id;

    private HostConfig host;

    private File catalinaHome;

    /*
     * The no-argument constructor, which is also a JavaBean convention, is a
     * requirement for all persistent classes
     */
    public TomcatConfig() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public HostConfig getHost() {
	return host;
    }

    public void setHost(HostConfig host) {
	this.host = host;
    }

    public File getCatalinaHome() {
	return catalinaHome;
    }

    public void setCatalinaHome(File catalinaHome) {
	this.catalinaHome = catalinaHome;
    }
}

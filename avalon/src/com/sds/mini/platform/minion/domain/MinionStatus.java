package com.sds.mini.platform.minion.domain;

import java.io.Serializable;

public class MinionStatus implements Serializable{
	private static final long serialVersionUID = 1L;
	String name;
    String type;
    String status;

    public MinionStatus() {
    }

    public MinionStatus(String name, String type, String status) {
        this.name = name;
        this.type = type;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

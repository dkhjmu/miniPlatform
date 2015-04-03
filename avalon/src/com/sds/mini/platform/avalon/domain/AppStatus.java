package com.sds.mini.platform.avalon.domain;

import java.io.Serializable;

public class AppStatus implements Serializable{
    String name;
    String status;

    public AppStatus() {
    }

    public AppStatus(String name, String status) {
        this.name = name;
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
}

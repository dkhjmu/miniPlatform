package com.sds.mini.platform.avalon.domain;

import java.io.Serializable;

public class AppStatus implements Serializable{
    String name;
    String status;

    public AppStatus(String name, String status) {
        this.name = name;
        this.status = status;
    }
}

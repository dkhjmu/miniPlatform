package com.sds.mini.platform.avalon.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class AgentInfo implements Serializable{
    private String url;
    private String name;
    private String path;
    private String cpu;
    private String disk;
    private List<AppStatus> apps = new LinkedList<>();

    public AgentInfo(String url, String name, String path, String cpu, String disk) {
        this.url = url;
        this.name = name;
        this.path = path;
        this.cpu = cpu;
        this.disk = disk;
    }

    public List<AppStatus> getApps() {
        return apps;
    }

}

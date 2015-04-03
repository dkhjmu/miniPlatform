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

    public AgentInfo() {
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public void setApps(List<AppStatus> apps) {
        this.apps = apps;
    }
}

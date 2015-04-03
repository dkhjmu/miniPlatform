package com.sds.mini.platform.minion.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class MinionInfo implements Serializable{
    private String url;
    private String name;
    private String status = "LIVE";
    private String path;
    private String cpu;
    private String memory;
    private String disk;
    private List<MinionStatus> apps = new LinkedList<>();

    public MinionInfo() {
    }

    public MinionInfo(String url, String name, String path, String cpu, String memory, String disk) {
        this.url = url;
        this.name = name;
        this.path = path;
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public List<MinionStatus> getApps() {
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

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public void setApps(List<MinionStatus> apps) {
        this.apps = apps;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Minion{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", path='" + path + '\'' +
                ", cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", disk='" + disk + '\'' +
                ", apps=" + apps +
                '}';
    }
}

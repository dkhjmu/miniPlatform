package com.sds.mini.platform.web;

import com.sds.mini.platform.minion.domain.MinionInfo;
import com.sds.mini.platform.minion.domain.MinionStatus;
import com.sds.mini.platform.avalon.domain.Result;
import com.sds.mini.platform.util.PropertyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.util.List;
import java.util.Properties;

@RestController
public class MockAgent {
    private String url;
    private String port;

    MockAgent() {
        try {
            port = PropertyUtils.getProperty("server.port");
            url = "http://" + InetAddress.getLocalHost().getHostAddress() + ":" + port;;
        } catch (Exception e) {
        }
    }

    @RequestMapping("/status")
    public MinionInfo agent() {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        String memory = ((freeMemory + (maxMemory - allocatedMemory)) / 1024 / 1024) + " mb";
        String cpu = ManagementFactory.getOperatingSystemMXBean().getArch();
        File file = new File("/");
        long disk = file.getTotalSpace() - file.getFreeSpace();
        String diskUsage = (disk / 1024 / 1024) + " mb";
        MinionInfo minionInfo = new MinionInfo(url, "agent1", new File("").getAbsolutePath(), cpu + "", memory + "", diskUsage);
        List<MinionStatus> apps = minionInfo.getApps();
        MinionStatus app1 = new MinionStatus("tibero", "DB", "DEAD");
        MinionStatus app2 = new MinionStatus("oracle","DB", "DEAD");
        MinionStatus app3 = new MinionStatus("jeus", "WEB", "RUN");
        MinionStatus app4 = new MinionStatus("mongod", "DB","DEAD");
        MinionStatus app5 = new MinionStatus("db2", "DB","DEAD");
        MinionStatus app6 = new MinionStatus("weblogic", "WEB", "RUN");
        apps.add(app1);
        apps.add(app2);
        apps.add(app3);
        apps.add(app4);
        apps.add(app5);
        apps.add(app6);
        return minionInfo;
    }

    @RequestMapping("/run/{app}/{run}")
    public Result run(@PathVariable("app") String app, @PathVariable("run") String run) {
        if ("start".equalsIgnoreCase(run)) return new Result(app + " Started");
        else if ("stop".equalsIgnoreCase(run)) return new Result(app + " Stopped");
        return new Result("Failed - run : " + run);
    }

    @RequestMapping("/healthCheck")
    public Result health() {
        return new Result("OK");
    }
}
package com.sds.mini.platform.web;

import com.sds.mini.platform.avalon.domain.AgentInfo;
import com.sds.mini.platform.avalon.domain.AppStatus;
import com.sds.mini.platform.avalon.domain.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Properties;

@RestController
public class MockAgent {
    private String url;
    private String port;

    MockAgent() {
        try {
            Properties prop = new Properties();
            prop.load(getClass().getResourceAsStream("/application.properties"));
            port = prop.getProperty("server.port");
            url = InetAddress.getLocalHost().getHostAddress() + ":" + port;
        } catch (Exception e) {
        }
    }

    @RequestMapping("/status")
    public AgentInfo agent() {
        AgentInfo agentInfo = new AgentInfo(url, "agent1", new File("").getAbsolutePath(), "cpu", "disk");
        List<AppStatus> apps = agentInfo.getApps();
        AppStatus app1 = new AppStatus("tibero", "RUN");
        AppStatus app2 = new AppStatus("db2", "DEAD");
        AppStatus app3 = new AppStatus("weblogic", "RUN");
        apps.add(app1);
        apps.add(app2);
        apps.add(app3);
        return agentInfo;
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
package com.sds.mini.platform.web;

import com.sds.mini.platform.avalon.domain.AgentInfo;
import com.sds.mini.platform.avalon.domain.AppStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.List;

@RestController
public class MockAgent {
    private String url;
    private int port;

    MockAgent(){
        try {
            url = InetAddress.getLocalHost().getHostAddress() + ":" + port;
        } catch (UnknownHostException e) {
        }
    }

    @RequestMapping("/status")
    public AgentInfo agent(){
        AgentInfo agentInfo = new AgentInfo(url, "agent1", "path", "cpu", "disk");
        List<AppStatus> apps = agentInfo.getApps();
        AppStatus app1 = new AppStatus("tibero", "RUN");
        AppStatus app2 = new AppStatus("db2", "DEAD");
        AppStatus app3 = new AppStatus("weblogic", "RUN");
        apps.add(app1);
        apps.add(app2);
        apps.add(app3);
        return agentInfo;
    }
    
    
}
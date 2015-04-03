package com.sds.mini.platform.web;

import com.sds.mini.platform.avalon.domain.AppInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class MockAgent {

    @RequestMapping("/apps")
    public List<AppInfo> agent(){
        List<AppInfo> apps = new LinkedList<>();
        AppInfo app1 = new AppInfo("tibero", "/tibero/app");
        AppInfo app2 = new AppInfo("db2", "/tibero/app");
        AppInfo app3 = new AppInfo("weblogic", "/tibero/app");
        apps.add(app1);
        apps.add(app2);
        apps.add(app3);
        return apps;
    }
    
    
}
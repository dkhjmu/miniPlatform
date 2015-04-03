package com.sds.mini.platform.web;

import com.sds.mini.platform.minion.domain.MinionInfo;
import com.sds.mini.platform.minion.service.AgentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MainController {
    @Resource
    private AgentService agentService;

    @RequestMapping("/main")
    public String index() {
        return "<script language='javascript'>  window.location = './index.html'; </script>";
    }

    @RequestMapping("/checkIn")
    public String checkIn(@RequestBody MinionInfo minionInfo) {
        boolean added = agentService.addMinion(minionInfo);
        if (added) return minionInfo.getName() + " agent added.";
        else return minionInfo.getName() + " agent add failed";
    }

    @RequestMapping("/checkOut/{minionName}")
    public String checkIn(@PathVariable("minionName") String minionName) {
        boolean removed = agentService.removeMinion(minionName);
        if (removed) return minionName + " agent removed.";
        else return minionName + " agent remove failed";
    }

    @RequestMapping("/minions")
    public Object status() {
        return agentService.getMinions();
    }

    @RequestMapping("/control/{agent}/{app}/{run}")
    public String run(@PathVariable("agent") String agentName, @PathVariable("app") String app, @PathVariable("run") String run) {
        return agentService.controlAgent(agentName, app, run);
    }

}
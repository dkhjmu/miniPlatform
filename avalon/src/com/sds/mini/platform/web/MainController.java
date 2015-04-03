package com.sds.mini.platform.web;

import com.sds.mini.platform.avalon.domain.AgentInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class MainController {
    private List<AgentInfo> agents = new LinkedList<>();

    @RequestMapping("/main")
    public String index() {
        return "<script language='javascript'>  window.location = './index.html'; </script>";
    }


    @RequestMapping("/checkIn")
    public String checkIn(@RequestBody AgentInfo agentInfo){
        boolean added = agents.add(agentInfo);
        if(added) return agentInfo.getName() + " agent added.";
        else return agentInfo.getName() + " agent add failed";
    }
    
}
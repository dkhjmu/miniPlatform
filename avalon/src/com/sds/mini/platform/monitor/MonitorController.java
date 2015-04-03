package com.sds.mini.platform.monitor;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sds.mini.platform.avalon.domain.AppInfo;
import com.sds.mini.platform.avalon.service.AppService;

@RestController
public class MonitorController {

    @RequestMapping("/monitor")
    public List<AppInfo> index() {
        return AppService.getInstance().allApps();
    }
    
}
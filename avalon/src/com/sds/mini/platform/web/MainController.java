package com.sds.mini.platform.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/main")
    public String index() {
        return "<script language='javascript'>  window.location = './index.html'; </script>";
    }
    
    
}
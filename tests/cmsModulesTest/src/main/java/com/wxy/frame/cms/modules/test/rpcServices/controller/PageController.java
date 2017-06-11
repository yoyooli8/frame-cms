package com.wxy.frame.cms.modules.test.rpcServices.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yoyoo on 17-4-15.
 */
@Controller
public class PageController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        return "index_easyui";
    }
    @RequestMapping(value = "/welcome",method = RequestMethod.GET)
    public String welcome(){
        return "welcome";
    }
}

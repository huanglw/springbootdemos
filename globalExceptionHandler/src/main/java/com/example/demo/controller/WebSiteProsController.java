package com.example.demo.controller;

import com.example.demo.service.WebSiteProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/website")
public class WebSiteProsController {
    @Autowired
    WebSiteProperties webProps;

    @RequestMapping("/props")
    @ResponseBody
    public String getProps(){
        return "All the props of website: " + webProps.toString();
    }
}

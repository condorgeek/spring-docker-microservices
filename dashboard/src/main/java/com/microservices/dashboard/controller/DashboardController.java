package com.microservices.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    CounterServiceProxy counterServiceProxy;

    @Value("${config.description:** Dashboard ** }")
    private String description;

    @Value("${server1.name:!undefined! }")
    private String server;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return description + server + counterServiceProxy.addCount();
    }

    @RequestMapping(value = "/substract", method = RequestMethod.GET)
    public String substract() {
        return description + server + counterServiceProxy.substractCount();
    }
}

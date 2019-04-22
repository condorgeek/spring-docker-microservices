package com.microservices.dashboard.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "CounterService")
@RibbonClient(name = "CounterService")
public interface CounterServiceProxy {

    @RequestMapping(value = "/counter/add", method = RequestMethod.GET)
    public String addCount();

    @RequestMapping(value = "/counter/substract", method = RequestMethod.GET)
    public String substractCount();

}

package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

@RestController
@RequestMapping("/counter")
public class CounterController {
    private int count = 0;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCount() {
        return hostname.get() + " count=" + ++count;
    }

    @RequestMapping(value = "/substract", method = RequestMethod.GET)
    public String substractCount() {
        return hostname.get() + " count=" + (count > 0 ? --count : 0);
    }

   private Supplier<String> hostname = () -> System.getenv().getOrDefault("HOSTNAME", "unknown");
}

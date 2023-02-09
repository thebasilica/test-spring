package com.debug500.dockerspringboot.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// test controller endpoint
@RestController

// v2
@RequestMapping("/app/v1/debug500")
public class HelloResource {
    @GetMapping
    public String hello() {
        return "echo from debug500";
    }
}
package com.exceptionhandling.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.exceptionhandling.demo.service.DemoService;

@RestController
class GreetingController {

  @Autowired
  DemoService service;

  @RequestMapping("/hello")
  String hello() throws Exception {
    Logger log = Logger.getLogger(getClass());
    log.info("Inside Greeting Controller");
    service.foo();

    return "Hello, World!";
  }
}

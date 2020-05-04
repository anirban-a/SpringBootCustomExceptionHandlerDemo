package com.exceptionhandling.demo.service;

import org.springframework.stereotype.Service;
import com.exceptionhandling.demo.exceptionhandler.MyException;

@Service
public class DemoService {

  public void foo() throws Exception {
    throw new MyException("Foo exception");
  }
}

package com.exceptionhandling.demo.exceptionhandler;

public class MyException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public MyException(String str) {
    super(str);
  }
}

package com.himanshu.poc.classloader.impl.v1;

import com.himanshu.poc.classloader.api.IHelloService;

public class HelloService implements IHelloService {

  private final String owner;

  public HelloService(String owner) {
    this.owner = owner;
  }

  @Override
  public String sayHello() {
    return "Saying hello from "+owner+ " via extension-2 "+HelloService.class.getCanonicalName();
  }
}

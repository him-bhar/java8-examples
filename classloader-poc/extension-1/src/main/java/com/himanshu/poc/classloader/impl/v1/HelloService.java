package com.himanshu.poc.classloader.impl.v1;

import com.himanshu.poc.classloader.api.IHelloService;

public class HelloService implements IHelloService {
  @Override
  public String sayHello() {
    return "Saying hello from "+HelloService.class.getCanonicalName();
  }
}

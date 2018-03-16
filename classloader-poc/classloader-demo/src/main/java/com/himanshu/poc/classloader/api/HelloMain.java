package com.himanshu.poc.classloader.api;

import java.io.File;
import java.net.MalformedURLException;

public class HelloMain {
  public static void main(String[] args) throws MalformedURLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
    String path = HelloMain.class.getResource("/").getFile();
    File currentPath = new File(path);
    File projectRoot = currentPath.getParentFile().getParentFile().getParentFile();
    String impl1Path = projectRoot.getPath()+"/extension-1/target/";
    String impl2Path = projectRoot.getPath()+"/extension-2/target/";

    HelloServiceClassloader impl1Loader = new HelloServiceClassloader(new File(impl1Path), f -> f.getName().endsWith("jar"));
    HelloServiceClassloader impl2Loader = new HelloServiceClassloader(new File(impl2Path), f -> f.getName().endsWith("jar"));

    IHelloService helloService1 = impl1Loader.resolveClass("com.himanshu.poc.classloader.impl.v1.HelloService");
    IHelloService helloService2 = impl2Loader.resolveClass("com.himanshu.poc.classloader.impl.v2.HelloService");

    System.out.println(helloService1.sayHello());
    System.out.println(helloService2.sayHello());
  }
}

package com.himanshu.poc.classloader.api;

import java.io.File;
import java.net.MalformedURLException;

public class HelloMain {
  public static void main(String[] args) throws MalformedURLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
    String path = HelloMain.class.getResource("/").getFile();
    File currentPath = new File(path);
    File projectRoot = currentPath.getParentFile().getParentFile().getParentFile();

    String impl1Path = projectRoot.getPath()+"/extension-1/target/";
    HelloServiceClassloader impl1Loader = new HelloServiceClassloader(new File(impl1Path), HelloMain::isJarFile);
    IHelloService helloService1 = impl1Loader.resolveClass("com.himanshu.poc.classloader.impl.v1.HelloService");
    System.out.println(helloService1.sayHello());

    String impl2Path = projectRoot.getPath()+"/extension-2/target/";
    HelloServiceClassloader impl2Loader = new HelloServiceClassloader(new File(impl2Path), HelloMain::isJarFile);
    IHelloService helloService2 = impl2Loader.resolveClass("com.himanshu.poc.classloader.impl.v2.HelloService");
    System.out.println(helloService2.sayHello());


  }

  private static boolean isJarFile(File f) {
    return f.getName().endsWith("jar");
  }
}

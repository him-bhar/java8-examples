package com.himanshu.poc.classloader.api;

import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HelloServiceClassloader {
  private final URLClassLoader classLoader;

  public HelloServiceClassloader(File jarFilePath, FileFilter filter) throws MalformedURLException {
    File[] files = jarFilePath.listFiles(filter);
    List<URL> urls = Arrays.stream(files).map(f -> {
      try {
        System.out.println("Adding url: "+f.getPath());
        return f.toURI().toURL();
      } catch (MalformedURLException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
      }
    }).collect(Collectors.toList());
    this.classLoader = new URLClassLoader(urls.toArray(new URL[urls.size()]));
  }

  public IHelloService resolveClass(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    Class clazz = this.classLoader.loadClass(className);
    IHelloService helloService = (IHelloService) clazz.newInstance();
    return helloService;
  }
}

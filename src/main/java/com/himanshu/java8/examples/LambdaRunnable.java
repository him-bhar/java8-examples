package com.himanshu.java8.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LambdaRunnable {
  private static Logger logger = LoggerFactory.getLogger(LambdaRunnable.class);

  public static void main(String[] args) {
    Concat c = (String str1, String str2) -> {
      return str1.concat(str2);
    };

    logger.info(c.concat(Thread.currentThread().getName(), " Starting main"));
    Runnable r = () -> {
      logger.info(c.concat(Thread.currentThread().getName(), " Hello Himanshu"));
    };
    Thread t = new Thread(r);
    t.start();
  }

  interface Concat {
    String concat(String str1, String str2);
  }

}

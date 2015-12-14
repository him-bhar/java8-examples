package com.himanshu.java8.examples;

public class LambdaRunnable {
  
  public static void main(String[] args) {
    Concat c = (String str1, String str2) -> {return str1.concat(str2);}; 
    
    System.out.println(c.concat(Thread.currentThread().getName(), " Starting main"));
    Runnable r = () -> {
      System.out.println(c.concat(Thread.currentThread().getName(), " Hello Himanshu"));
    };
    Thread t = new Thread(r);
    t.start();
  }
  
  interface Concat {
    String concat(String str1, String str2);
  }

}
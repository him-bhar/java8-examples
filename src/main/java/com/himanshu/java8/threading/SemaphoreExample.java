package com.himanshu.java8.threading;

import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SemaphoreExample {
  private static Logger logger = LoggerFactory.getLogger(SemaphoreExample.class);
  
  private Semaphore semaphore = new Semaphore(3); //Only 3 threads can enter critical section at a time
  
  public static void main(String[] args) {
    SemaphoreExample se = new SemaphoreExample();
    Runnable r = () -> {
      logger.info("Inside runnable "+Thread.currentThread().getName());
      
      try {
        se.semaphore.acquire();
        logger.info("Inside critical section. Sleeping for 20 seconds "+Thread.currentThread().getName());
        Thread.sleep(20000l);
        logger.info("Inside critical section "+Thread.currentThread().getName());
      } catch (Exception e) {
        throw new RuntimeException(e);
      } finally {
        se.semaphore.release();
      }
      logger.info("Left critical section "+Thread.currentThread().getName());
    };
    new Thread(r, "Thread-1").start();;
    new Thread(r, "Thread-2").start();;
    new Thread(r, "Thread-3").start();;
    new Thread(r, "Thread-4").start();;
    new Thread(r, "Thread-5").start();;
    
  }

}

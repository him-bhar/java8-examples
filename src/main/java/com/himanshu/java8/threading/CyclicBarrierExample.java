package com.himanshu.java8.threading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @see <a>http://tutorials.jenkov.com/java-util-concurrent/cyclicbarrier.html</a>
 * @author himanshu
 *
 * The java.util.concurrent.CyclicBarrier class is a synchronization mechanism that can synchronize threads progressing 
 * through some algorithm. In other words, it is a barrier that all threads must wait at, 
 * until all threads reach it, before any of the threads can continue.
 */
public class CyclicBarrierExample {
  private CyclicBarrier barrier = new CyclicBarrier(2, () -> {logger.info("Barrier runnable executed");});
  private static Logger logger = LoggerFactory.getLogger(CyclicBarrier.class);
  
  private Runnable createRunnable() {
    return () -> {logger.info("Starting execution for thread "+Thread.currentThread().getName());
      logger.info("Sleeping thread "+Thread.currentThread().getName() + " 10 seconds");
      try {
        Thread.sleep(10000l);
        barrier.await();
      } catch (InterruptedException | BrokenBarrierException e) {
        throw new RuntimeException(e);
      }
      logger.info("Completed execution for thread "+Thread.currentThread().getName());
    };
  }
  
  public static void main(String[] args) {
    CyclicBarrierExample cbe = new CyclicBarrierExample();
    Thread t1 = new Thread(cbe.createRunnable(), "Thread-1");
    Thread t2 = new Thread(cbe.createRunnable(), "Thread-2");
    //Thread t3 = new Thread(cbe.createRunnable(), "Thread-3");
    t1.start();
    t2.start();
    //t3.start();
  }

}

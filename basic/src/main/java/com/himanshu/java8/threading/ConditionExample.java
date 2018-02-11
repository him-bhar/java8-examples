package com.himanshu.java8.threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConditionExample {
  
  private Lock lock = new ReentrantLock();
  private Condition condition1 = lock.newCondition();
  private static Logger logger = LoggerFactory.getLogger(ConditionExample.class);
  
  public static void main(String[] args) throws InterruptedException {
    final ConditionExample ce = new ConditionExample();
    Thread t1 = new Thread(() -> {try {
        ce.lock.lockInterruptibly();
        ce.condition1.await();
        logger.info("Thread-1 after condition");
        ce.condition1.signalAll();
      } catch(Exception e) {
        throw new RuntimeException(e);
      } finally {
        ce.lock.unlock();
      }
    }, "Thread-1");
    
    Thread t2 = new Thread(() -> {try {
        ce.lock.lockInterruptibly();
        ce.condition1.signalAll();;
        logger.info("Thread-2 after signal");
      } catch(Exception e) {
        throw new RuntimeException(e);
      } finally {
        ce.lock.unlock();
      }
    }, "Thread-2");
    
    t1.start();
    t2.start();
    
  }

}

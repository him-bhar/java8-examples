package com.himanshu.java8.threading;

public class CounterWaitNotify {
  private int counter = 1;
  private Object obj = new Object();
  private Runnable counterRunnable(COUNTER_TYPE counterType) {
    return () -> {
      while(true) {
        synchronized (obj) {
          if(counterType == COUNTER_TYPE.EVEN) {
            while (counter%2 != 0) {
              try {
                obj.wait();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
            System.out.println(Thread.currentThread().getName() +" "+ counter);
            counter++;
            obj.notify();
          } else {
            while (counter%2 != 0) {
              obj.notify();

              System.out.println(Thread.currentThread().getName() +" "+ counter);
              counter++;
              try {
                obj.wait();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
          }
          try {
            Thread.sleep(1000l);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    };
  }

  private enum COUNTER_TYPE {
    EVEN, ODD
  }

  public static void main(String[] args) {
    CounterWaitNotify counterWaitNotify = new CounterWaitNotify();
    Runnable rOdd = counterWaitNotify.counterRunnable(COUNTER_TYPE.ODD);
    Runnable rEven = counterWaitNotify.counterRunnable(COUNTER_TYPE.EVEN);
    Thread oddThread = new Thread(rOdd, "ODD-THREAD");
    Thread evenThread = new Thread(rEven, "EVEN-THREAD");
    oddThread.start();
    evenThread.start();
  }

}

package com.himanshu.java8.threading;

import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CompletionServiceDemo {
  private static AtomicInteger counter = new AtomicInteger(0);
  private static class Person {
    int id;
    String name;

    public Person(int id, String name) {
      this.id = id;
      this.name = name;
    }

    @Override
    public String toString() {
      return "Person{" +
              "id=" + id +
              ", name='" + name + '\'' +
              '}';
    }
  }
  public static void main(String[] args) {
    ExecutorService execService = Executors.newFixedThreadPool(3);
    CompletionService<Person> completionService = new ExecutorCompletionService<Person>(execService);
    for (int i=0;i<100;i++) {
      completionService.submit(ceateCallable());
    }
    for(int i=0;i<100;i++) {
      try {
        System.out.println(completionService.take().get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
    completionService.poll();

    execService.shutdown();
  }

  public static Callable<Person> ceateCallable() {
    return () -> {
      System.out.println("Creating new person via: "+Thread.currentThread().getName());
      return new Person(counter.incrementAndGet(), UUID.randomUUID().toString());
    };
  }
}

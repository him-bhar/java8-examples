package com.himanshu.java8.threading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureDemo {
  public static void main(String[] args) throws InterruptedException, ExecutionException {

    CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
      System.out.println(Thread.currentThread().getName() + " Printing hello");
      return "Hello";
    }).thenCompose((String s) -> {
      return CompletableFuture.supplyAsync(() -> {
        System.out.println(Thread.currentThread().getName() + " Adding abc");
        return s+" abc";});
    }).thenApplyAsync((String s) -> {
      System.out.println(Thread.currentThread().getName() + " Adding world");
      return s + " World";
    }).thenApplyAsync((String s) -> {
      System.out.println(Thread.currentThread().getName() + " Adding name");
      if (false) {
        throw new RuntimeException("Oh no exception");
      }
      return s + " player!";
    }).thenCombine(CompletableFuture.supplyAsync(() -> {
      System.out.println(Thread.currentThread().getName() + " Adding xyz");
      return " xyz";}), new BiFunction<String, String, String>() {
      @Override
      public String apply(String s, String s2) {
        return s+s2;
      }
    }).handle((String s, Throwable t) -> {
      System.out.println(s != null ? s : "BLANK");
      System.out.println(t != null ? t.getMessage() : "BLANK Exception");
      return s != null ? s : t.getMessage();
    });

    //System.out.println(completableFuture.get());
  }
}

package com.himanshu.java8.examples.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListStream {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("test");
    list.add("anothertest");
    
    List<String> listResult = list.parallelStream().filter(new Predicate<String>() {

      @Override
      public boolean test(String t) {
        return t.startsWith("test");
      }
    }).collect(Collectors.toList());
    System.out.println(listResult);
  }
}

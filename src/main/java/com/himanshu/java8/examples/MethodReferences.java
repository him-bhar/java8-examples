package com.himanshu.java8.examples;

import java.util.Set;
import java.util.TreeSet;

public class MethodReferences {
  public int intCompare (Integer i1, Integer i2) {
    return i1.compareTo(i2);
  }
  
  private Set<Integer> sampleTreeSet = new TreeSet<>(this::intCompare);
  
  public static void main(String[] args) {
    MethodReferences mr = new MethodReferences();
    mr.sampleTreeSet.add(999);
    mr.sampleTreeSet.add(998);
    mr.sampleTreeSet.add(1);
    mr.sampleTreeSet.add(1000);
    mr.sampleTreeSet.add(500);
    System.out.println(mr.sampleTreeSet);
  }
}

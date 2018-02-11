package com.himanshu.java8.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SortListUsingLambda {
  
  private List<Integer> integers = new ArrayList<>();
  private static Logger logger = LoggerFactory.getLogger(SortListUsingLambda.class);
  
  public static void main(String[] args) {
    SortListUsingLambda obj = new SortListUsingLambda();
    obj.integers.add(10);
    obj.integers.add(5);
    obj.integers.add(7);
    obj.integers.add(1);
    obj.integers.add(3);
    
    Comparator<Integer> comparator = (Integer a, Integer b) -> {
      return a.compareTo(b);
    };
    
    Collections.sort(obj.integers, comparator);
    logger.info(obj.integers.toString());
  }

}

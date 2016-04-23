package com.himanshu.java8.examples;

import java.util.function.BiFunction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcatenatorUsingLambda {
  private static Logger logger = LoggerFactory.getLogger(ConcatenatorUsingLambda.class);
  
  private BiFunction<String, String, String> concatFunction = this::concatString;
  
  public String concat(String str1, String str2) {
    Concat c = (str3, str4) -> {
      String str5 = str3+" lalalala "+str4;
      return str5;
    };
    return c.concat(str1, str2);
  }
  
  private String concatString(String str1, String str2) {
    return str1+" "+str2;
  }
  
  public String applyConcatUsingMethodReference(String str1, String str2) {
    return concatFunction.apply(str1, str2);
  }
  
  @FunctionalInterface
  private interface Concat {
    String concat(String str1, String str2);
  }

}

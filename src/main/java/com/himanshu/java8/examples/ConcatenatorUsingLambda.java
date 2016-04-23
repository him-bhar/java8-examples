package com.himanshu.java8.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcatenatorUsingLambda {
  private static Logger logger = LoggerFactory.getLogger(ConcatenatorUsingLambda.class);
  
  public String concat(String str1, String str2) {
    Concat c = (str3, str4) -> {
      String str5 = str3+" lalalala "+str4;
      return str5;
    };
    return c.concat(str1, str2);
  }

  interface Concat {
    String concat(String str1, String str2);
  }

}

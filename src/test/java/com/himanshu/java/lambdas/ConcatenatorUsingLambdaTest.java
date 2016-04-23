package com.himanshu.java.lambdas;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.himanshu.java8.examples.ConcatenatorUsingLambda;

public class ConcatenatorUsingLambdaTest {
  private static Logger logger = LoggerFactory.getLogger(ConcatenatorUsingLambdaTest.class);
  
  @Test
  public void shouldConcatenateStringsWithLalala() {
    String str1 = "Hello";
    String str2 = "World";
    
    ConcatenatorUsingLambda concatenator = new ConcatenatorUsingLambda();
    String str3 = concatenator.concat(str1, str2);
    logger.info("Output string : {}", str3);
    Assert.assertThat(str3, Matchers.containsString(str1));
    Assert.assertThat(str3, Matchers.containsString(str2));
    Assert.assertThat(str3, Matchers.containsString("lalalala"));
  }
}

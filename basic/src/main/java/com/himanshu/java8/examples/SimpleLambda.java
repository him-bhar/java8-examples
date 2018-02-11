package com.himanshu.java8.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleLambda {
  private static Logger logger = LoggerFactory.getLogger(SimpleLambda.class);
  public static void main(String args[]) {
    SimpleLambda tester = new SimpleLambda();

    // with type declaration
    MathOperation addition = (int a, int b) -> a + b;

    // with out type declaration
    MathOperation subtraction = (a, b) -> a - b;

    // with return statement along with curly braces
    MathOperation multiplication = (int a, int b) -> {
      return a * b;
    };

    // without return statement and without curly braces
    MathOperation division = (int a, int b) -> a / b;

    logger.info("10 + 5 = " + tester.operate(10, 5, addition));
    logger.info("10 - 5 = " + tester.operate(10, 5, subtraction));
    logger.info("10 x 5 = " + tester.operate(10, 5, multiplication));
    logger.info("10 / 5 = " + tester.operate(10, 5, division));

    // with parenthesis
    GreetingService greetService1 = message -> logger.info("Hello " + message);

    // without parenthesis
    GreetingService greetService2 = (message) -> logger.info("Helloz " + message);

    greetService1.sayMessage("Mahesh");
    greetService2.sayMessage("Suresh");
  }

  interface MathOperation {
    int operation(int a, int b);
  }

  interface GreetingService {
    void sayMessage(String message);
  }

  private int operate(int a, int b, MathOperation mathOperation) {
    return mathOperation.operation(a, b);
  }
}

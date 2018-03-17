package com.himanshu.poc.junit5.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculatorHandler {
  private static Logger logger = LoggerFactory.getLogger(CalculatorHandler.class);

  public int add(int a, int b) {
    logger.info("Adding {} & {}", a, b);
    return a+b;
  }

  public int subtract(int a, int b) {
    logger.info("Subtracting {} & {}", a, b);
    return a-b;
  }

  public int multiply(int a, int b) {
    logger.info("Multiplying {} & {}", a, b);
    return a*b;
  }

  public int divide(int a, int b) {
    logger.info("Dividing {} & {}", a, b);
    return a/b;
  }
}

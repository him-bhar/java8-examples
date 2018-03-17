package com.himanshu.poc.junit5.api;

public class Calculator {

  private final CalculatorHandler calculatorHandler;

  public Calculator(CalculatorHandler calculatorHandler) {
    this.calculatorHandler = calculatorHandler;
  }

  public int add(int a, int b) {
    return this.calculatorHandler.add(a, b);
  }

  public int subtract(int a, int b) {
    return this.calculatorHandler.subtract(a, b);
  }

  public int multiply(int a, int b) {
    return this.calculatorHandler.multiply(a, b);
  }

  public int divide(int a, int b) {
    return this.calculatorHandler.divide(a, b);
  }
}

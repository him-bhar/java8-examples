package com.himanshu.poc.junit5.api;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing calculator operations")
class CalculatorTest {
  private Calculator calculator = new Calculator(new CalculatorHandler());

  @Test
  @DisplayName("Testing operation add")
  void testAdd() {
    int result = calculator.add(2, 3);
    Assertions.assertAll(() -> Assertions.assertNotNull(result));
  }

  @Test
  @DisplayName("Testing operation subtract")
  void testSubtract() {
    int result = calculator.subtract(2, 3);
    Assertions.assertAll(() -> Assertions.assertNotNull(result));
  }

  @Test
  @DisplayName("Testing operation multiply")
  void testMultiply() {
    int result = calculator.multiply(2, 3);
    Assertions.assertAll(() -> Assertions.assertNotNull(result));
  }

  @Test
  @DisplayName("Testing operation divide")
  void testDivide() {
    int result = calculator.divide(2, 3);
    Assertions.assertAll(() -> Assertions.assertNotNull(result));
  }

  @Test
  @DisplayName("Testing operation divide by zero")
  void testDivideByZero() {
    Assertions.assertAll(() -> Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(2, 0)));
  }
}

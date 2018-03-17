package com.himanshu.poc.junit5.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.extension.MockitoExtension;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
class CalculatorWithMockingTest {

  @Test
  public void testAdd(@Mock CalculatorHandler calculatorHandler) {
    Calculator calculator = new Calculator(calculatorHandler);
    BDDMockito.given(calculatorHandler.add(Mockito.anyInt(), Mockito.anyInt())).willReturn(7);
    Assertions.assertAll(
            () -> Assertions.assertTrue(calculator.add(2, 3) == 7),
            () -> Assertions.assertTrue(calculator.add(4, 5) == 7),
            () -> Assertions.assertTrue(calculator.add(6, 10) == 7)
    );
    Mockito.verify(calculatorHandler, Mockito.times(3)).add(Mockito.anyInt(), Mockito.anyInt());
  }

  @Test
  public void testAddWithSpy() {
    CalculatorHandler calculatorHandler = new CalculatorHandler();
    CalculatorHandler calculatorHandlerSpy = Mockito.spy(calculatorHandler);
    Calculator calculator = new Calculator(calculatorHandlerSpy);
    //Delegating to actual method, for first two combinations and mocking for last
    BDDMockito.given(calculatorHandlerSpy.add(6, 10)).willReturn(7);
    Assertions.assertAll(
            () -> Assertions.assertTrue(calculator.add(2, 3) == 5),
            () -> Assertions.assertTrue(calculator.add(4, 5) == 9),
            () -> Assertions.assertTrue(calculator.add(6, 10) == 7)
    );
    Mockito.verify(calculatorHandlerSpy, Mockito.times(3)).add(Mockito.anyInt(), Mockito.anyInt());
  }

}

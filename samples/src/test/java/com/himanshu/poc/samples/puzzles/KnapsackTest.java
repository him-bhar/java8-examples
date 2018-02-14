package com.himanshu.poc.samples.puzzles;

import org.junit.Assert;
import org.junit.Test;

public class KnapsackTest {

  @Test
  public void shouldCalculateMaxPossibleValue() {
    Knapsack knapsack = new Knapsack(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50);
    Assert.assertTrue(220 == knapsack.calculateMaxValue());
  }

  @Test
  public void shouldReturnZeroInCaseOfNoElements() {
    Knapsack knapsack = new Knapsack(new int[]{}, new int[]{}, 50);
    Assert.assertTrue(0 == knapsack.calculateMaxValue());
  }

  @Test(expected = Exception.class)
  public void shouldThrowExceptionInCaseOfElementsMismatch() {
    Knapsack knapsack = new Knapsack(new int[]{}, new int[]{10}, 50);
    knapsack.calculateMaxValue(); //should throw exception here
    Assert.fail(); //should never reach here
  }
}

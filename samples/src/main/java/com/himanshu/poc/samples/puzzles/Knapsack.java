package com.himanshu.poc.samples.puzzles;

import com.google.common.base.Preconditions;

/**
 * @see <a href="https://www.geeksforgeeks.org/knapsack-problem/">Knapsack problem</a>
 * <p>
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the
 * maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1]
 * which represent values and weights associated with n items respectively. Also given an integer W which
 * represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of
 * this subset is smaller than or equal to W. You cannot break an item, either pick the complete item,
 * or don’t pick it (0-1 property).
 * </p>
 */
public class Knapsack {
  private final int[] value;
  private final int[] wt;
  private final int knapsackWt;  //W

  public Knapsack(int[] value, int[] wt, int knapsackWt) {
    Preconditions.checkArgument(value.length == wt.length, "Value and weight array size mismatch");
    this.value = value;
    this.wt = wt;
    this.knapsackWt = knapsackWt;
  }

  public int calculateMaxValue() {
    return calculateMaxValue(value, wt, knapsackWt, wt.length);
  }

  private int calculateMaxValue(int[] value, int[] wt, int knapsackWt, int length) {
    //Either knapsack or weights are not present
    if (knapsackWt == 0 || length == 0) {
      return 0;
    }
    //knapsack weight is less than element weight
    if (wt[length-1] > knapsackWt) {
      return calculateMaxValue(value, wt, knapsackWt, length-1);
    }
    //Check possibility with or without the current weight
    else {
      return Math.max(
              value[length-1] + calculateMaxValue(value, wt, knapsackWt-wt[length-1], length-1),
              calculateMaxValue(value, wt, knapsackWt, length-1)
             );
    }
  }
}

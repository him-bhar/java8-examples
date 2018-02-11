package com.himanshu.math.puzzles;

/**
 * LCM of two numbers (in simple terms) is the least number which is divisible by both the numbers.
 * 
 * There are 2 ways to implement this solution:
 * 1. User formula : (GCD*LCM) = (Product of the numbers)
 * 2. Since LCM will always be greater than both numbers. So start from greater number 
 * and check when it divides with both number providing zero remainder.   
 * 
 * @author himanshu
 *
 */
public class LeastCommonMultiple {
  
  public static long findLCMUsingGCD(long a, long b) {
    long gcd = GreatestCommonDivisor.GCD(a, b);
    return (a*b)/gcd;
  }
  
  public static long findLCMUsingLoop(long a, long b) {
    long lcm = a*b;
    for (long i=b;i<(a*b);i++) {
      if ((i%a == 0) && (i%b == 0)) {
        lcm = Math.min(lcm, i);
      }
    }
    return lcm;
  }
  
  public static void main(String[] args) {
    System.out.println(findLCMUsingGCD(10, 12));
    System.out.println(findLCMUsingLoop(10, 12));
  }
}

package com.himanshu.math.puzzles;

/**
 * The Euclidean algorithm is based on the principle that the greatest common
 * divisor of two numbers does not change if the larger number is replaced by
 * its difference with the smaller number. For example, 21 is the GCD of 252 and
 * 105 (252 = 21 * 12 and 105 = 21 * 5), and the same number 21 is also the GCD
 * of 105 and 147 = 252 - 105. Since this replacement reduces the larger of the
 * two numbers, repeating this process gives successively smaller pairs of
 * numbers until the two numbers become equal. When that occurs, they are the
 * GCD of the original two numbers. By reversing the steps, the GCD can be
 * expressed as a sum of the two original numbers each multiplied by a positive
 * or negative integer, e.g., 21 = 5 * 105 + (-2) * 252. The fact that the GCD
 * can always be expressed in this way is known as Bezout's identity.
 * 
 * @author himanshu
 *
 */
public class GreatestCommonDivisor {
  public static long GCD(long a, long b) {
    if (a == b) {
      return a;
    } else if (a > b) {
      a = a - b;
    } else {
      b = b - a;
    }
    return GCD(a, b);
  }
  
  public static void main(String[] args) {
    System.out.println(GCD(252, 105));
  }
}

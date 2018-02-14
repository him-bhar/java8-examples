package com.himanshu.poc.samples.puzzles;

/**
 * @see <a href="https://www.geeksforgeeks.org/longest-common-subsequence/">Longest Common Subsequence</a>
 * <p>
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a string of length n has 2^n different possible subsequences.
 * It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences between two files), and has applications in bioinformatics.
 * Examples:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 * </p>
 */
public class LongestCommonSubSequence {
  private final String input1;
  private final String input2;

  public LongestCommonSubSequence(String input1, String input2) {
    this.input1 = input1;
    this.input2 = input2;
  }

  public int findLongestCommonSubSequence() {
    return findLongestCommonSubSequence(input1.toCharArray(), input2.toCharArray(), input1.length(), input2.length());
  }

  public int findLongestCommonSubSequenceNonRecursive() {
    return findLongestCommonSubSequenceNonRecursive(input1.toCharArray(), input2.toCharArray(), input1.length(), input2.length());
  }

  private int findLongestCommonSubSequence(char[] input1, char[] input2, int input1Length, int input2Length) {
    if (input1Length == 0 || input2Length == 0) {
      return 0;
    }
    if (input1[input1Length - 1] == input2[input2Length - 1]) {
      return 1 + findLongestCommonSubSequence(input1, input2, input1Length - 1, input2Length - 1);
    } else {
      return Math.max(
              findLongestCommonSubSequence(input1, input2, input1Length - 1, input2Length),
              findLongestCommonSubSequence(input1, input2, input1Length, input2Length - 1)
      );
    }
  }

  private int findLongestCommonSubSequenceNonRecursive(char[] input1, char[] input2, int input1Length, int input2Length) {
    int result[][] = new int[input1Length + 1][input2Length + 1];
    for (int i = 0; i <= input1Length; i++) {
      for (int j = 0; j <= input2Length; j++) {
        if (i == 0 || j == 0) {
          result[i][j] = 0;
        } else if (input1[i - 1] == input2[j - 1]) {
          result[i][j] = 1 + result[i - 1][j - 1];
        } else {
          result[i][j] = Math.max(result[i][j - 1], result[i - 1][j]);
        }
      }
    }
    return result[input1Length][input2Length];
  }
}

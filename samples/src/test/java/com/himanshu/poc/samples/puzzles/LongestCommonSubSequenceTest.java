package com.himanshu.poc.samples.puzzles;

import org.junit.Assert;
import org.junit.Test;

public class LongestCommonSubSequenceTest {
  @Test
  public void shouldCalculateLongestSubSequence1() {
    LongestCommonSubSequence lcs = new LongestCommonSubSequence("AGGTAB", "GXTXAYB");
    Assert.assertTrue(4 == lcs.findLongestCommonSubSequence());
    Assert.assertTrue(4 == lcs.findLongestCommonSubSequenceNonRecursive());
  }

  @Test
  public void shouldCalculateLongestSubSequence2() {
    LongestCommonSubSequence lcs = new LongestCommonSubSequence("ABCDGH", "AEDFHR");
    Assert.assertTrue(3 == lcs.findLongestCommonSubSequence());
    Assert.assertTrue(3 == lcs.findLongestCommonSubSequenceNonRecursive());
  }

  @Test
  public void shouldReturnZeroForAnEmptyInput() {
    LongestCommonSubSequence lcs = new LongestCommonSubSequence("ABCDGH", "");
    Assert.assertTrue(0 == lcs.findLongestCommonSubSequence());
    Assert.assertTrue(0 == lcs.findLongestCommonSubSequenceNonRecursive());
  }
}

package Leetcode;

/**
 * Created by csy99 on 4/1/20.
 * <p>
 * Assume you have an array of length n initialized with all 0's
 * and are given k update operations.
 * <p>
 * Each operation is represented as a triplet:
 * [startIndex, endIndex, inc]
 * which increments each element of subarray
 * A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 * <p>
 * Return the modified array after all k operations were executed.
 */

public class Q370_Range_Addition {
    /*
    The idea is to utilize the fact that the array initializes with zero.
    The hint suggests us that we only needs to modify the first and last element of the range.
    In fact, we need to increment the first element in the range
    and decreases the last element + 1 (if it's within the length) by inc.
    Then we sum up all previous results.
    Why does this work? When we sum up the array,
    the increment is passed along to the subsequent elements
    until the last element.
    When we decrement the end + 1 index, we offset the increment
    so no increment is passed along to the next element.
     */
  public int[] getModifiedArray(int length, int[][] updates) {
    int[] tmp = new int[length + 1];
    for (int[] range: updates) {
      int start = range[0];
      int end = range[1]+1;
      int op = range[2];
      tmp[start] += op;
      tmp[end] -= op;
    }
    int[] res = new int[length];
    res[0] = tmp[0];
    for (int i = 1; i < length; i++)
      res[i] = res[i-1] + tmp[i];
    return res;  
  }

    public static void main(String[] args) {
        int[][] updates = new int[][]{
                {1, 3, 2},
                {2, 4, 3},
                {0, 2, -2}
        };
        Q370_Range_Addition sol = new Q370_Range_Addition();
        int[] res = sol.getModifiedArray(5, updates);
        System.out.println(res);
    }
}

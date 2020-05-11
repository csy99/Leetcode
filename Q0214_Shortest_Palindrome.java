package Leetcode;

/**
 * Created by csy99 on 3/21/20.
 */
public class Q214_Shortest_Palindrome {
  public String shortestPalindrome(String s) {
    String reversed = new StringBuilder(s).reverse().toString();
    // use special char to avoid overlap;
    String full = s + "*" + reversed;
    int[] arr = new int[full.length()];  // kmp table
    // i: suffix boundary, j: prefix boundary
    for (int i = 1; i < arr.length; i++) {
      int j = arr[i-1];
      // move to the last match in prefix
      while (j > 0 && full.charAt(i) != full.charAt(j))
        j = arr[j - 1];
      if (full.charAt(i) == full.charAt(j))
        arr[i] = j + 1;
    }
    return reversed.substring(0, s.length() - arr[arr.length - 1]) + s;
  }
}

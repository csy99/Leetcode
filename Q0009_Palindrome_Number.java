package Leetcode;

/**
 * Created by csy99 on 3/21/20.
 * <p>
 * Determine whether an integer is a palindrome.
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 * Input: 121
 * Output: true
 *
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121.
 * From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 */
public class Q009_Palindrome_Number {
  // convert to string
  public boolean isPalindrome(int x) {
    if (x < 0)
      return false;
    char[] str = Integer.toString(x).toCharArray();
    int l = 0, r = str.length - 1;
    while (l < r) {
      if (str[l++] != str[r--])
        return false;
    }
    return true;
  }
    
  // not convert to string
  public boolean isPalindrome(int x) {
    if (x < 0) return false;
    int reversed = 0;
    int remainder;
    int original = x;
    while (x != 0) {
      remainder = x % 10;
      reversed = reversed * 10 + remainder;
      x /= 10;
    }
    return original == reversed;
  }
}

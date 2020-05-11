package Leetcode;

/**
 * Created by csy99 on 3/21/20.
 */
public class Q125_Valid_Palindrome {
  public boolean isPalindrome(String s) {
    if (s == null || s.length() == 0) return true;
    char[] arr = s.toLowerCase().toCharArray();
    int l = 0, r = s.length() - 1;
    while (l < r) {
      while (!Character.isLetterOrDigit(arr[l])) {
        if (++l >= r) return true;
      }
      while (!Character.isLetterOrDigit(arr[r])) {
        if (l >= --r) return true;
      }
      if (arr[l++] != arr[r--]) return false;
    }
    return true;
  }
}

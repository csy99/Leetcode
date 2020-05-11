package Leetcode;

/**
 * Created by csy99 on 3/17/20.
 */
public class Q344_Reverse_String {
  public void reverseString(char[] s) {
    if (s == null || s.length < 2)
      return;
    int l = 0;
    int r = s.length - 1;
    while (l < r) {
      char tmp = s[l];
      s[l++] = s[r];
      s[r--] = tmp;
    }
    return;
  }
}

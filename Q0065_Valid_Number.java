package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q065_Valid_Number {
  public boolean isNumber(String s) {
    if (s == null || s.length() == 0) return false;
    s = s.trim();
    int i = 0;
    int n = s.length();
    if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
    boolean isDigits = false;
    while (i < n && Character.isDigit(s.charAt(i))) {
      i++;
      isDigits = true;
    }
    // check past . parts
    if (i < n && s.charAt(i) == '.') {
      i++;
      while (i < n && Character.isDigit(s.charAt(i))) {
        i++;
        isDigits = true;
      }
    }
    // check exponential
    if (i < n && s.charAt(i) == 'e' && isDigits) {
      i++;
      isDigits = false;
      if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
      while (i < n && Character.isDigit(s.charAt(i))) {
        i++;
        isDigits = true;
      }
    }
    return isDigits && i == s.length();
  }
}

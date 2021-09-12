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

class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        int n = s.length();
        boolean point = false;
        boolean e = false;
        boolean number = false;
        boolean number_behind_e = true;
        for (int i = 0; i < n; i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if ('0' <= c && c <= '9') {
                number = true;
                number_behind_e = true;
            } else if (c == '.') {
                if (e || point)
                    return false;
                point = true;
            } else if (c == 'e') {
                if (e || !number) 
                    return false;
                number_behind_e = false;
                e = true;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i-1) != 'e')
                    return false;
            } else
                return false;
        }
        return number && number_behind_e;
    }
}

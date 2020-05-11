package Leetcode;

/**
 * Created by csy99 on 3/19/20.
 */
public class Q171_Excel_Sheet_Column_Number {
  public int titleToNumber(String s) {
    if (s.length() == 0) return 0;
    int res = 0;
    int factor = 1;
    for (int i = s.length() - 1; i >= 0; i--) {
      res += (s.charAt(i) - 'A' + 1) * factor;
      factor *= 26;
    }
    return res;
  }
}

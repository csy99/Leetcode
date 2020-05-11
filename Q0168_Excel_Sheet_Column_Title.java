package Leetcode;

/**
 * Created by csy99 on 3/19/20.
 */
public class Q168_Excel_Sheet_Column_Title {
  public String convertToTitle(int n) {
    if (n < 1) return "";
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      n--;  // corner case: n is the multiple of 26
      char c = (char) (n % 26 + 'A');
      sb.insert(0, c);
      n /= 26;
    }
    return sb.toString();
  }
}

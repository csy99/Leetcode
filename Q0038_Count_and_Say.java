package Leetcode;

/**
 * Created by csy99 on 3/18/20.
 * <p>
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 *
 * Example:
 *
 * Input: 4
 * Output: "1211"
 */
public class Q038_Count_and_Say {
  public String countAndSay(int n) {
    String res = "1";
    if (n < 1) return "";
    while (n > 1) {
      res = countSay(res);
      n--;
    }
    return res;
  }
  
  public String countSay(String str) {
    int cnt = 1;
    char prev = str.charAt(0);
    int p = 1;
    StringBuilder sb = new StringBuilder();
    while (p < str.length()) {
      if (str.charAt(p) != prev) {
        sb.append(cnt);
        sb.append(prev);
        prev = str.charAt(p);
        cnt = 1;
      } else {
        cnt++;
      }
      p++;
    }
    sb.append(cnt);
    sb.append(prev);
    return sb.toString();
  }
}

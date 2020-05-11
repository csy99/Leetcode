package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by csy99 on 3/19/20.
 * <p>
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees
 * (looked at upside down).
 * <p>
 * Find all strobogrammatic numbers that are of length = n.
 * <p>
 * For example, Given n = 2, return ["11","69","88","96"].
 */
public class Q247_Strobogrammatic_Number_II {
  private final char[][] map = {{'0','0'}, {'1','1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
  
  public List<String> findStrobogrammatic(int n) {
    List<String> res = new ArrayList<>();
    if (n < 1) return res;
    char[] chars = new char[n];
    helper(chars, 0, n-1, res);
    return res;
  }
  
  public void helper(char[] chars, int l, int r, List<String> res) {
    if (l > r) {
      // corner case: "0" is a valid strobogrammatic number
      if (chars.length == 1 || chars[0] != '0')
        res.add(String.valueOf(chars));
      return;
    }
    for (char[] pair: map) {
      if (l == r && pair[0] != pair[1]) continue;
      chars[l] = pair[0];
      chars[r] = pair[1];
      helper(chars, l+1, r-1, res);
    }
  }
}

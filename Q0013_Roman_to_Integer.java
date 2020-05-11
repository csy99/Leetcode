package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csy99 on 3/19/20.
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * Example 1:
 * Input: "III"
 * Output: 3
 *
 * Example 2:
 * Input: "IV"
 * Output: 4
 *
 * Example 3:
 * Input: "IX"
 * Output: 9
 *
 * Example 4:
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 *
 * Example 5:
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 */
public class Q013_Roman_to_Integer {
  public int convert(char c) {
    if (c == 'I')
      return 1;
    if (c == 'V')
      return 5;
    if (c == 'X')
      return 10;
    if (c == 'L')
      return 50;
    if (c == 'C')
      return 100;
    if (c == 'D')
      return 500;
    if (c == 'M')
      return 1000;
    return 0;
  }
  
  public int romanToInt(String s) {
    if (s == null || s.length() == 0) return 0;
    int res = 0;
    if (s.indexOf("CM") >= 0) res -= 200;
    if (s.indexOf("CD") >= 0) res -= 200;
    if (s.indexOf("XC") >= 0) res -= 20;
    if (s.indexOf("XL") >= 0) res -= 20;
    if (s.indexOf("IX") >= 0) res -= 2;
    if (s.indexOf("IV") >= 0) res -= 2;
    for (char c: s.toCharArray()) {
      res += convert(c);
    }
    return res;
  }
}

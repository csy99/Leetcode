package Leetcode;

/**
 * Created by csy99 on 3/19/20.
 */
public class Q012_Integer_to_Roman {
  public String intToRoman(int num) {
    String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < roman.length && num > 0; i++) {
      while (num >= val[i]) {
        num -= val[i];
        sb.append(roman[i]);
      }
    }

    return  sb.toString();
  }
}

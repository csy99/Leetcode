package Leetcode;

import java.util.Arrays;

/**
 * Created by csy99 on 3/18/20.
 */
public class Q087_Scramble_String {
  public boolean isScramble(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() != s2.length())
      return false;
    if (s1.length() == 1 && s1.equals(s2)) return true;
    char[] tmp1 = s1.toCharArray();
    char[] tmp2 = s2.toCharArray();
    Arrays.sort(tmp1);
    Arrays.sort(tmp2);
    String val1 = new String(tmp1);
    String val2 = new String(tmp2);
    if (!val1.equals(val2)) return false;
    for (int i = 1; i < s1.length(); i++) {
      String left1 = s1.substring(0, i);
      String right1 = s1.substring(i);
      String left2 = s2.substring(0, i);
      String right2 = s2.substring(i);
      if (isScramble(left1,left2) && isScramble(right1,right2))
        return true;
      if (isScramble(left1, s2.substring(s2.length()-i)) && 
         isScramble(right1, s2.substring(0, s2.length()-i)))
        return true;
    }
    return false;
  }
}

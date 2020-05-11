package Leetcode;

/**
 * Created by csy99 on 3/17/20.
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 */
public class Q058_Length_of_Last_Word {
  public int lengthOfLastWord(String s) {
    if (s == null || s.length() == 0)
      return 0;
    return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    // int idx = -1;
    // s = s.trim();
    // for (int i = 0; i < s.length(); i++) {
    //   if (s.charAt(i) == ' ')
    //     idx = i;
    // }
    // return s.length() - idx - 1;
  } 
}

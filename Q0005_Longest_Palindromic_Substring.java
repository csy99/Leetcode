package Leetcode;

/**
 * Created by csy99 on 3/21/20.
 * <p>
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 */
public class Q0005_Longest_Palindromic_Substring {
  public String longestPalindrome(String s) {
    if (s == null || s.length() == 0) return "";
    boolean[][] isP = new boolean[s.length()][s.length()];
    int start = 0;
    int len = 1; 
    for (int i = 0; i < s.length(); i++)  // only one char
      isP[i][i] = true;
    for (int i = 0; i < s.length() - 1; i++) {  // two chars
      if (s.charAt(i) == s.charAt(i+1)) {
        isP[i][i+1] = true;
        start = i; 
        len = 2;
      }
    }
    for (int l = 3; l < s.length()+1 ; l++) {
      for (int i = 0; i+l-1 < s.length(); i++) {
        if (isP[i+1][i+l-2] && s.charAt(i) == s.charAt(i+l-1)) {
          isP[i][i+l-1] = true;
          start = i;
          len = l;
        }
      }
    }
    return s.substring(start, start+len);
  }
}

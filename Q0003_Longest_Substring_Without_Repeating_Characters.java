package Leetcode;


/**
 * Created by csy99 on 3/20/20.
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class Q003_Longest_Substring_Without_Repeating_Characters {
  public int lengthOfLongestSubstring(String s) {
    int[] pos = new int[128];  // next valid place for each character
    int maxLen = 0;
    int l = 0;  // starting point of a valid substring
    for (int r = 0; r < s.length(); r++) {
      l = Math.max(l, pos[s.charAt(r)]);  // next pos of the seen character
      maxLen = Math.max(maxLen, r-l+1);
      pos[s.charAt(r)] = r+1;
    }
    return maxLen;
  }

}

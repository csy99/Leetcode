package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by csy99 on 3/20/20.
 * <p>
 * Find the length of the longest substring T of a given string
 * (consists of lowercase letters only)
 * such that every character in T appears no less than k times.
 */
public class Q395_Longest_Substring_with_At_Least_K_Repeating_Characters {
  public int longestSubstring(String s, int k) {
    if (s == null || s.length() == 0)
      return 0;
    int[] freq = new int[26];
    for (int i = 0; i < s.length(); i++)
      freq[s.charAt(i) - 'a']++;
    boolean fullString = true;
    for (int i = 0; i < s.length(); i++) {
      if (freq[s.charAt(i) - 'a'] > 0 && freq[s.charAt(i) - 'a'] < k) {
        fullString = false;
        break;
      }
    }
    if (fullString) return s.length();
    
    int l = 0, r = 0;
    int res = 0;
    while (r < s.length()) {
      if (freq[s.charAt(r) - 'a'] < k) {  // split the string into two parts
        res = Math.max(res, longestSubstring(s.substring(l, r), k));
        l = r+1;
      }
      r++;
    }
    res = Math.max(res, longestSubstring(s.substring(l), k));
    return res;
  }
}

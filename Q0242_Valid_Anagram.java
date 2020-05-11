package Leetcode;

/**
 * Created by csy99 on 3/18/20.
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 */
public class Q242_Valid_Anagram {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length())
      return false;
    int[] cnt = new int[26];
    for (int i = 0; i < s.length() ; i++) {
      int idx = s.charAt(i) - 97;
      cnt[idx]++;
    }
    for (int i = 0; i < s.length() ; i++) {
      int idx = t.charAt(i) - 97;
      cnt[idx]--;
      if (cnt[idx] < 0)
        return false;
    }
    return true;
  }
}

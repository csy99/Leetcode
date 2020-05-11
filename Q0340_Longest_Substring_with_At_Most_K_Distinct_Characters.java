package Leetcode;

/**
 * Given a string S, find the length of the longest substring T that contains at most k distinct characters.
 * Example 1:
 * Input: S = "eceba" and k = 3
 * Output: 4
 * Explanation: T = "eceb"
 * 
 * Example 2:
 * Input: S = "WORLD" and k = 4
 * Output: 4
 * Explanation: T = "WORL" or "ORLD"
 *
 * Created by csy99 on 3/20/20.
 */
public class Q340_Longest_Substring_with_At_Most_K_Distinct_Characters {
  // char frequency   
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int maxLen = 0;
    HashMap<Character, Integer> freq = new HashMap();
    int l = 0, r = 0;
    while (l < s.length()) {
      while (r < s.length() && freq.size() < k+1) {
        char ending = s.charAt(r);
        if (freq.containsKey(ending))
          freq.put(ending, freq.get(ending)+1);
        else {
          if (freq.size() == k)  // can't add a diff char
            break;
          freq.put(ending, 1);
        }
        r++;
      }
      maxLen = Math.max(maxLen, r-l);
      // move left pointer, and update the frequency HashMap
      char starting = s.charAt(l);
      if (freq.containsKey(starting)) {
        if (freq.get(starting) == 1)
          freq.remove(starting);
        else
          freq.put(starting, freq.get(starting)-1);
      }
      l++;
    }
    return maxLen;
  }
}

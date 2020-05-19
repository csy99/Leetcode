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
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.isEmpty()) return 0;
        int l = 0;
        int r = 0;
        int longest = 0;
        HashMap<Character, Integer> pos = new HashMap();
        while (r < s.length()) {
            pos.put(s.charAt(r), r);
            r++;
            if (pos.size() > k) {
                int last = s.length();
                for (char key: pos.keySet()) 
                    last = Math.min(last, pos.get(key));
                pos.remove(s.charAt(last));
                l = last+1;
            }
            if (r-l > longest)
                longest = r-l;
        }
        return longest;
    }
}

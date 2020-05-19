package Leetcode;


/**
 * Created by csy99 on 3/20/20.
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class Q003_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        int[] pos = new int[128];
        int l = 0;
        int r = 0;
        int longest = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (pos[c] <= l) {
                pos[c] = r + 1;
                longest = Math.max(longest, r-l+1);
                r++;
            } else{
                l = pos[c];
            }
        }
        return longest;
    }
}

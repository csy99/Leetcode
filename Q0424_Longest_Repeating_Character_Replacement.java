package Leetcode;

/**
 * Created by csy99 on 8/31/20.
 */
public class Q424_Longest_Repeating_Character_Replacement {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if (n == 0 || k >= n) return n;
        int[] cnt = new int[26];
        int l = 0;
        int max_cnt = 0;
        int longest = 0;
        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);
            cnt[c-'A']++;
            max_cnt = Math.max(max_cnt, cnt[c-'A']);
            while (r - l + 1> k + max_cnt) {
                char front = s.charAt(l);
                cnt[front-'A']--;
                l++;
            }
            longest = Math.max(longest, r-l+1);
        }
        return longest;
    }
}

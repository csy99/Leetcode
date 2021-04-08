package Leetcode;

/**
 * Created by csy99 on 4/7/21.
 */
public class Q467_Unique_Substrings_in_Wraparound_String {
    // time: O(n), space: O(n)
    public int findSubstringInWraproundString(String p) {
        int n = p.length();
        if (n == 0) return 0;
        int res = 0;
        int[] cnt = new int[26];
        cnt[p.charAt(0)-'a'] = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            char c = p.charAt(i);
            if (p.charAt(i-1)+1 == c || (p.charAt(i-1) == 'z' && c == 'a') )
                dp[i] = dp[i-1] + 1;
            else
                dp[i] = 1;
            cnt[c-'a'] = Math.max(cnt[c-'a'], dp[i]);
        }
        for (int num: cnt)
            res += num;
        return res;
    }
}

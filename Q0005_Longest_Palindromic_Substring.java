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
        int n = s.length();
        if (n == 0) return "";
        // isPa[i][j] true if s[i~j] is palindrome
        boolean[][] isPa = new boolean[n][n];
        int l = 0;
        int longest = 1;
        for (int idx = 0; idx < n; idx++)  // one char is palidrome
            isPa[idx][idx] = true;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n-len; i++) {
                int j = i+len-1;
                if (s.charAt(i) != s.charAt(j))
                    continue;
                if (len == 2) 
                    isPa[i][j] = true;
                else
                    isPa[i][j] = isPa[i+1][j-1];
                if (isPa[i][j] == true) {
                    longest = len;
                    l = i;
                }
            }
        }
        return s.substring(l, l+longest);
    }
}

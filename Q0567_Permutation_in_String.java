package Leetcode;

/**
 * Created by csy99 on 10/26/20.
 */
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n) return false;
        int[] chars1 = new int[26];
        int[] chars2 = new int[26];
        for (char c: s1.toCharArray())
            chars1[c-'a']++;
        for (int i = 0; i < m; i++)
            chars2[s2.charAt(i)-'a']++;
        for (int i = m; i < n; i++) {
            boolean match = true;
            for (int c = 0; c < 26; c++)
                if (chars1[c] != chars2[c]) {
                    match = false;
                    break;
                }
            if (match) return true;
            char prev = s2.charAt(i-m);
            chars2[prev-'a']--;
            chars2[s2.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++)
            if (chars1[i] != chars2[i])
                return false;
        return true;
    }
}

package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by csy99 on 8/26/20.
 */
public class Q409_Longest_Palindrome {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        int res = 0;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                res += 2;
            } else {
                set.add(c);
            }
        }

        if (set.size() > 0) {
            res += 1;
        }

        return res;
    }
}

class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return n;
        int[] cnt = new int[52];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z')
                cnt[c - 'A']++;
            else
                cnt[c - 'a' + 26]++;
        }
        int even = 0;
        int odd = 0;
        boolean add = false;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0 && cnt[i] % 2 == 0)
                even += cnt[i];
            else if (cnt[i] % 2 == 1) {
                odd += cnt[i] - 1;
                add = true;
            }
        }
        if (!add)
            return even;
        return 1 + odd + even;
    }
}

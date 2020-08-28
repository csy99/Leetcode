package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 8/228/20.
 */
public class Q438_Find_All_Anagrams_in_a_String {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        List<Integer> res = new ArrayList();
        if (m < n) return res;
        int[] pattern = new int[26];
        for (char c: p.toCharArray())
            pattern[c-'a']++;
        int match = 0;
        int[] cur = new int[26];
        int l = 0;
        int r = 0;
        while (r < m) {
            char c = s.charAt(r);
            while (l <= r && cur[c-'a'] >= pattern[c-'a']) {
                char front = s.charAt(l);
                cur[front-'a']--;
                if (cur[front-'a'] < pattern[front-'a'])
                    match--;
                l++;
            }
            if (cur[c-'a']++ < pattern[c-'a']) {
                match++;
                if (match == n) 
                    res.add(r-n+1);
            }
            r++;
        }
        return res;
    }
}

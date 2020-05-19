package Leetcode;

import java.util.Arrays;

/**
 * Created by csy99 on 5/19/20.
 */
public class Q455_Assign_Cookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        int l = 0;
        int r = 0;
        while (l < g.length && r < s.length) {
            if (g[l] <= s[r]) {
                cnt++;
                l++;
            }
            r++;
        }
        return cnt;
    }
}

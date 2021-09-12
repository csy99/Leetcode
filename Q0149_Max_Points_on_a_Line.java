package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csy99 on 9/12/21.
 */
// use x0 and y0 to track each possible line. y0/x0 = (y2-y1)/(x2-x1) = (y3-y1)/(x3-x1)
// time: O(n^2), space: O(k)
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 0) return n;
        Map<Integer, Map<Integer, Integer>> map = new HashMap();
        int res = 0;
        for (int i = 0; i < n; i++) {
            map.clear();
            int overlap = 0;
            int mx = 0;
            for (int j = i+1; j < n; j++) {
                int x = points[j][0]- points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == x) {
                    overlap++;
                    continue;
                }
                int gcd = gcd(x,y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }
                Map<Integer, Integer> inside = map.getOrDefault(x, new HashMap());
                int cnt = inside.getOrDefault(y, 0) + 1;
                inside.put(y, cnt);
                map.put(x, inside);
                mx = Math.max(mx, cnt);
            }
            res = Math.max(res, mx+overlap+1);
        }
        return res;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}

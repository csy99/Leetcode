package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csy99 on 8/31/20.
 */
public class Q447_Number_of_Boomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int d = dist(points[i], points[j]);
                HashMap<Integer, Integer> dist_map = map.getOrDefault(d, new HashMap());
                int size1 = dist_map.getOrDefault(i, 0);
                int size2 = dist_map.getOrDefault(j, 0);
                res += 2*(size1 + size2);
                dist_map.put(i, size1+1);
                dist_map.put(j, size2+1);
                map.put(d, dist_map);
            }
        }
        return res;
    }
    
    private int dist(int[] p1, int[] p2) {
        return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
    }
    
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<points.length; i++) {
            for(int j=0; j<points.length; j++) {
                if(i == j)
                    continue;

                int d = getDistance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }

            for(int val : map.values()) {
                res += val * (val-1);
            }
            map.clear();
        }

        return res;
    }

    private int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx*dx + dy*dy;
    }
}

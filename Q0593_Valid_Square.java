package Leetcode;

/**
 * Created by csy99 on 10/7/21.
 */
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = new int[4][];
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
        points[3] = p4;
        Set<Long> set = new HashSet();
        for (int i = 0; i < 4; i++)
            for (int j = i+1; j < 4; j++) {
                long dist = dist(points[i], points[j]);
                if (dist == 0) return false;
                set.add(dist);
            }
        return set.size() == 2;
    }
    
    private long dist(int[] a, int[] b) {
        long dy = a[0] - b[0];
        long dx = a[1] - b[1];
        return dy*dy + dx*dx;
    }
}

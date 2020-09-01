package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by csy99 on 9/1/20.
 */
public class Q452_Minimum_Number_of_Arrows_to_Burst_Balloons {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n <= 1) return n;
        Arrays.sort(points, (a,b)->(a[1]-b[1]) );
        int res = 1;
        int cut = points[0][1];
        for (int i = 0; i < n; i++) {
            if (points[i][0] <= cut)
                continue;
            cut = points[i][1];
            res++;
        }
        return res;
    }
}

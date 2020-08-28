package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by csy99 on 8/28/20.
 */
public class Q435_Non_overlapping_Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int res = 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                int end_cmp = Integer.compare(arr1[1], arr2[1]);
                if (end_cmp != 0) return end_cmp;
                return Integer.compare(arr1[0], arr2[0]);
            }
        });
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (intervals[i][0] >= end)
                end = intervals[i][1];
            else
                res++;
        }
        return res;
    }
}

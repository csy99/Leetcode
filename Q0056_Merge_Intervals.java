package Leetcode;

/**
 * Created by csy99 on 3/14/20.
 */
public class Q056_Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n <= 1) return intervals; 
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        ArrayList<int[]> merged = new ArrayList();
        int[] prev = intervals[0];
        for (int i = 1; i < n; i++) {
            int[] cur = intervals[i];
            if (cur[0] <= prev[1]) {  // these two intervals can be merged
                prev[1] = Math.max(prev[1], cur[1]);
            } else {
                merged.add(prev);
                prev = cur;
            }
        }
        merged.add(prev);
        int[][] res = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) 
            res[i] = merged.get(i);
        return res;
    }
}

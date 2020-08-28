package Leetcode;

/**
 * Created by csy99 on 8/28/20.
 */
public class Q436_Find_Right_Interval {
    public int[] findRightInterval(int[][] intervals) {
        // key is the ending point of each interval, val is the idx
        TreeMap<Integer, Integer> map = new TreeMap();
        int n = intervals.length;
        for (int i = 0; i < n; i++) 
            map.put(intervals[i][0], i);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            Integer key = map.ceilingKey(intervals[i][1]);
            if (key == null)
                res[i] = -1;
            else
                res[i] = map.get(key);
        }
        return res;
    }
}

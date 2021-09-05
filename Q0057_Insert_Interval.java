package Leetcode;

import java.util.ArrayList;

/**
 * Created by csy99 on 3/14/20.
 */
public class Q057_Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      if (intervals.length == 0) {
        int[][] tmp = new int[1][2];
        tmp[0] = newInterval;
        return tmp;
      }
      
      int l = 0;
      int r = intervals.length - 1;
      int mid = 0;
      while (l < r) {  // find the right place to insert
        mid = l + (r - l)/2;
        if (intervals[mid][0] == newInterval[0]) {
          break;
        } else if (intervals[mid][0] > newInterval[0]) {
          r = mid;
        } else {
          l = mid + 1;
        }
      }
      mid = l + (r - l)/2;
      // happens when the newInterval should be inserted at the end of array
      if (intervals[mid][0] < newInterval[0])  
        mid++;
      
      ArrayList<int[]> res = new ArrayList<>();
      for (int i = 0; i < mid; i++) {
        res.add(intervals[i]);
      }
      // new interval is inserted at the front || no overlap
      if (mid == 0 || newInterval[0] > res.get(res.size()-1)[1]) {  
        res.add(newInterval);
      } else {  // need to merge
        int end = Math.max(res.get(res.size()-1)[1], newInterval[1]);
        res.get(res.size()-1)[1] = end;
      } 
      
      for (int i = mid; i < intervals.length; i++) {
        if (intervals[i][0] <= res.get(res.size()-1)[1]) {  // need to merge
          int end = Math.max(res.get(res.size()-1)[1], intervals[i][1]);
          res.get(res.size()-1)[1] = end;
        } else {  // no overlap
          res.add(intervals[i]);
        }
      }
      
      int[][] ans = new int[res.size()][2];
      for (int i = 0; i < res.size(); i++) {
        ans[i] = res.get(i);
      }
      
      return ans;
    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        List<int[]> merge = new ArrayList();
        int i = 0;
        boolean succ = false;
        while (i < intervals.length) {
            if (intervals[i][0] <= start && intervals[i][1] >= start
                || intervals[i][0] >= start && intervals[i][0] <= end) {
                int[] cur = new int[2];
                succ = true;
                cur[0] = Math.min(intervals[i][0], start);
                cur[1] = Math.max(intervals[i][1], end);
                i++;
                while (i < intervals.length && intervals[i][0] <= cur[1]) {
                    cur[1] = Math.max(cur[1], intervals[i][1]);
                    i++;
                }
                merge.add(cur);
                continue;
            }
            if (!succ && intervals[i][0] > end) {
                merge.add(newInterval);
                succ = true;
            }
            merge.add(intervals[i]);
            i++;
        }
        if (!succ) {
            if (merge.size() > 0 && end < merge.get(0)[0]) 
                merge.add(0, newInterval);
            else
                merge.add(newInterval);
        }
        int[][] res = new int[merge.size()][];
        for (int j = 0; j < merge.size(); j++)
            res[j] = merge.get(j);
        return res;
    }
}

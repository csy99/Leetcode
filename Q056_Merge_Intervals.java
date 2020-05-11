package Leetcode;

/**
 * Created by csy99 on 3/14/20.
 */
public class Q056_Merge_Intervals {
  public int[][] merge(int[][] intervals) {
      if (intervals == null || intervals.length <= 1)
        return intervals;
      Arrays.sort(intervals, new Comparator<int[]>() {
        public int compare(int[] arr1, int[] arr2) {
          return Integer.compare(arr1[0], arr2[0]);
        }
      });
      ArrayList<int[]> res = new ArrayList<>();
      res.add(intervals[0]);
      for (int i = 1; i < intervals.length; i++) {
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

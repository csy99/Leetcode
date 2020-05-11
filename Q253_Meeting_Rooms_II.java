package Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by csy99 on 3/14/20.
 * <p>
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...]
 * find the minimum number of conference rooms required.
 */

public class Q253_Meeting_Rooms_II {
/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
     /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
      if (intervals == null || intervals.size() <= 1)
        return intervals.size();
      int size = intervals.size();
      int[] startArr = new int[size];
      int[] endArr = new int[size];
      for (int i = 0; i < size; i++) {
        startArr[i] = intervals.get(i).start;
        endArr[i] = intervals.get(i).end;
      }
      Arrays.sort(startArr);
      Arrays.sort(endArr);
      int cur = 0;  // current # of meetings
      int res = 0;  // # of rooms needed
      int i = 0;
      int j = 0;
      while (i < size) {
        if (startArr[i] < endArr[j]) {  // a new meeting starts
          cur++;
          if (cur > res)
            res = cur;
          i++;
        } else {  // an old meeting ends
          cur--;
          j++;
        }
      }
      return res;
    }
}

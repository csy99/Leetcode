package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by csy99 on 3/14/20.
 * <p>
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 * <p>
 * For example, Given [[0, 30],[5, 10],[15, 20]], return false.
 */

public class Q252_Meeting_Rooms {
 /**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
    
    public boolean canAttendMeetings(List<Interval> intervals) {
      if (intervals == null || intervals.size() <= 1)
        return true;
      Collections.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval i1, Interval i2) {
          return Integer.compare(i1.start, i2.start);
        }
      });
      int start = intervals.get(0).start;
      int end = intervals.get(0).end;
      for (int i = 1; i < intervals.size(); i++) {
        Interval interval = intervals.get(i);
        if (interval.start < end)
          return false;
        start = interval.start;
        end = interval.end;
      }
      return true;
    }
}

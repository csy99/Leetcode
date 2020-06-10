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
        int n = intervals.size();
        if (n <= 1) return true;
        Collections.sort(intervals, (a,b)->(a.start-b.start));
        for (int i = 1; i < n; i++) {
            if (intervals.get(i).start < intervals.get(i-1).end)
                return false;
        }
        return true;
    }
}

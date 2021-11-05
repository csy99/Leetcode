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
    // PriorityQueue, time: O(n*logn), space: O(k)
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0) return 0;
        Collections.sort(intervals, (a,b)->(a.start-b.start));
        PriorityQueue<Integer> pq = new PriorityQueue();
        pq.add(intervals.get(0).end);
        for (int i = 1; i < n; i++) {
            Interval cur = intervals.get(i);
            int prev_end = pq.peek();
            if (cur.start >= prev_end)  // no conflicts
                pq.poll();
            pq.offer(cur.end);
        }
        return pq.size();
    }

    // two pointers, time: O(n*logn), space: O(1)
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0) return 0;
        Integer[] starts = new Integer[n];
        Integer[] ends = new Integer[n];
        for (int i = 0; i < n; i++) {
            Interval cur = intervals.get(i);
            starts[i] = cur.start;
            ends[i] = cur.end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int lastEnd = 0;
        for (int i = 0; i < n; i++) {
            if (starts[i] < ends[lastEnd])
                rooms++;
            else
                lastEnd++;
        }
        return rooms;
    }
}

// sweeping line, time: O(n log n), space: O(n)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        List<Event> events = new ArrayList();
        int res = 0;
        int cur = 0;
        for (int[] interval: intervals) {
            events.add(new Event(interval[0], 1));
            events.add(new Event(interval[1], -1));
        }
        Collections.sort(events);
        for (Event e: events) {
            if (e.type == 1) {
                cur++;
                res = Math.max(res, cur);
            } else
                cur--;
        }
        return res;
    }
}


class Event implements Comparable<Event>{
    int ts;
    int type;  // end:-1, start:1

    public Event(int t, int tp) {
        ts = t;
        type = tp;
    }

    public int compareTo(Event o) {
        if (ts != o.ts)
            return Integer.compare(ts, o.ts);
        return Integer.compare(type, o.type);
    }
}

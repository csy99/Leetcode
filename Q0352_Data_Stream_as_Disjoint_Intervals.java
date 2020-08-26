package Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by csy99 on 8/26/20.
 */
public class Q352_Data_Stream_as_Disjoint_Intervals {
    TreeSet<Interval> set;

    /**
     * Initialize your data structure here.
     */
    public Q352_Data_Stream_as_Disjoint_Intervals() {
        set = new TreeSet<Interval>(new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
    }

    public void addNum(int val) {
        Interval t = new Interval(val, val);

        Interval floor = set.floor(t);
        if (floor != null) {
            if (val <= floor.end) {
                return;
            } else if (val == floor.end + 1) {
                t.start = floor.start;
                set.remove(floor);
            }
        }

        Interval ceil = set.higher(t);
        if (ceil != null) {
            if (ceil.start == val + 1) {
                t.end = ceil.end;
                set.remove(ceil);
            }
        }

        set.add(t);
    }


    public List<Interval> getIntervals() {
        return Arrays.asList(set.toArray(new Interval[0]));
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}


class SummaryRanges {

    HashMap<Integer, Integer> map = new HashMap();
    HashSet<Integer> start = new HashSet();
    
    /** Initialize your data structure here. */
    public SummaryRanges() {
        
    }
    
    public void addNum(int val) {
        if (map.containsKey(val))
            return;
        int left_len = map.getOrDefault(val-1, 0);
        int right_len = map.getOrDefault(val+1, 0);
        int total_len = left_len + 1 + right_len;
        map.put(val, total_len);
        map.put(val - left_len, total_len);
        map.put(val + right_len, total_len);
        start.remove(val + 1);
        if (left_len == 0)
            start.add(val);
    }
    
    public int[][] getIntervals() {
        List<int[]> intervals = new ArrayList();
        for (int key: start) {
            int len = map.get(key);
            intervals.add(new int[] {key, key+len-1});
        }
        Collections.sort(intervals, (a,b)->(a[0]-b[0]));
        int[][] res = new int[intervals.size()][2];
        for (int i = 0; i < res.length; i++)
            res[i] = intervals.get(i);
        return res;
    }
}

    TreeMap<Integer, Integer> map = new TreeMap();
    
    /** Initialize your data structure here. */
    public SummaryRanges() {
        
    }
    
    public void addNum(int val) {
        if (map.containsKey(val))
            return;
        int left_len = map.getOrDefault(val-1, 0);
        int right_len = map.getOrDefault(val+1, 0);
        int total_len = left_len + 1 + right_len;
        map.put(val + right_len, total_len);
        map.put(val - left_len, total_len);
        map.put(val, total_len);
    }
    
    public int[][] getIntervals() {
        List<int[]> intervals = new ArrayList();
        int ending = -1;
        while (true) {
            Integer key = map.ceilingKey(ending);
            if (key == null) break;
            int val = map.get(key);
            int[] tmp = new int[] {key, key + val - 1};
            intervals.add(tmp);
            ending = key + val;
        }
        int[][] res = new int[intervals.size()][2];
        for (int i = 0; i < res.length; i++)
            res[i] = intervals.get(i);
        return res;
    }
}

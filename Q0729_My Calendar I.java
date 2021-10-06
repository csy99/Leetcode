/**
 * Created by csy99 on 10/5/21.
 */
// TreeMap, time: O(n log n), space: O(n)
class MyCalendar {
    // key: ts, val: 0 start/ 1 end
    TreeMap<Double, Integer> map;
    public MyCalendar() {
        map = new TreeMap();
    }
    
    public boolean book(int start, int end) {
        double s = start;
        double e = end - 0.01;
        Double ts_pre_start = map.floorKey(s);
        Double ts_pre_end = map.floorKey(e);
        if (ts_pre_start != ts_pre_end) return false;
        if (ts_pre_start != null && map.get(ts_pre_start) == 0) return false;
        Double ts_nxt_start = map.ceilingKey(s);
        Double ts_nxt_end = map.ceilingKey(e);
        if (ts_nxt_start != ts_nxt_end) return false;
        map.put(s, 0);
        map.put(e, 1);
        return true;
    }
}
class MyCalendar {
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap();
    }
    
    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}


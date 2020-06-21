/**
 * Created by csy99 on 6/21/20.
 */
class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];
        // track the day when a lake is filled
        HashMap<Integer, Integer> dates = new HashMap();
        // days used to empty the lake
        TreeSet<Integer> empty = new TreeSet();
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                empty.add(i);
                res[i] = 1;  // may be updated later
            } else {
                res[i] = -1;
                if (dates.containsKey(rains[i])) {
                    Integer day = empty.ceiling(dates.get(rains[i]));
                    if (day == null)
                        return new int[0];
                    else {
                        res[day] = rains[i];
                        empty.remove(day);
                    }
                }
                dates.put(rains[i], i);
            }
        }
        return res;
    }
}

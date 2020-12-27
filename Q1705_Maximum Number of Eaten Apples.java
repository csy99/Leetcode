/**
 * Created by csy99 on 12/26/20 during contest.
 */
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        TreeMap<Integer, Integer> total = new TreeMap();
        int i = 0;
        int res = 0;
        for (; i < n; i++) {
            total.remove(i);
            Integer remaining = total.get(i+days[i]);
            if (remaining == null) 
                remaining = 0;
            if (days[i] != 0)
                total.put(i+days[i], remaining+apples[i]);
            Integer todayKey = total.ceilingKey(i);
            if (todayKey == null) continue;
            res++;
            int todayVal = total.get(todayKey);
            if (todayVal > 1)
                total.put(todayKey, todayVal-1);
            else
                total.remove(todayKey);
        }
        while (total.size() > 0) {
            total.remove(i);
            Integer todayKey = total.ceilingKey(i);
            if (todayKey == null) continue;
            res++;
            int todayVal = total.get(todayKey);
            if (todayVal > 1)
                total.put(todayKey, todayVal-1);
            else
                total.remove(todayKey);
            i++;
        }
        return res;
    }
}

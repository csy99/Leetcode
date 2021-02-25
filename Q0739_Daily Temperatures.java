/**
 * Created by csy99 on 2/25/21.
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        if (n == 0) return res;
        List<Integer> monoq = new ArrayList();
        for (int i = 0; i < n; i++) {
            while (monoq.size() > 0 && T[monoq.get(monoq.size()-1)] < T[i]) {
                int prev_idx = monoq.get(monoq.size()-1);
                monoq.remove(monoq.size()-1);
                res[prev_idx] = i - prev_idx;
            }
            monoq.add(i);
        }
        return res;
    }
}

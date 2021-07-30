/**
 * Created by csy99 on 7/30/21.
 */
public class Solution {
    public int MinimumCost(List<Integer> sticks) {
        int res = 0;
        while (sticks.size() > 1) {
            Collections.sort(sticks);
            int first = sticks.remove(0);
            int second = sticks.remove(0);
            res += first+second;
            sticks.add(first+second);
        }
        return res;
    }
}

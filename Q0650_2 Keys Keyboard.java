/**
 * Created by csy99 on 3/31/21.
 */
class Solution {
    Map<Integer, Integer> map = new HashMap();
    public int minSteps(int n) {
        return helper(n);
    }
    
    private int helper(int n) {
        if (n == 1) return 0;
        if (map.containsKey(n)) return map.get(n);
        int res = n;
        int group = 2;
        while (group <= n/2) {
            int cur = helper(group);
            if ((n%group) == 0) {
                cur += n/group;
                res = Math.min(res, cur);
            }
            group++;
        }
        map.put(n, res);
        return res;
    }
}

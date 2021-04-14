package Leetcode;

/**
 * Created by rbhatnagar2 on 4/14/21.
 */
class Solution {
    Map<Integer, Boolean> map;
    public boolean canIWin(int maxChoosableInteger, int target) {
        int sum = (1+maxChoosableInteger)*maxChoosableInteger/2;
        if (sum < target) return false;
        if (target <= 0) return true;
        map = new HashMap();
        boolean[] used = new boolean[maxChoosableInteger+1];
        return helper(used, target);
    }
    
    private boolean helper(boolean[] used, int target) {
        if (target <= 0) return false;
        int key = format(used);
        if (map.containsKey(key))
            return map.get(key);
         for (int i = 1; i < used.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            if (!helper(used, target-i)) {
                map.put(key, true);
                used[i] = false;
                return true;
            }
            used[i] = false;
         }
        map.put(key, false);
        return false;
    }
    
    private int format(boolean[] used) {
        int num = 0;
        for (boolean b: used) {
            num <<= 1;
            if (b)
                num++;
        }
        return num;
    }
}

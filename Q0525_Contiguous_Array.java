package Leetcode;

/**
 * Created by csy99 on 7/28/21.
 */
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int res = 0;
        int score = 0;
        Map<Integer, Integer> pos = new HashMap();
        pos.put(0, -1);
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) score++;
            else score--;
            if (pos.containsKey(score))
                res = Math.max(res, i-pos.get(score));
            else
                pos.put(score, i);
        }
        return res;
    }
}

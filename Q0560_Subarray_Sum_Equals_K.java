package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csy99 on 9/8/20.
 */
public class Q560_Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        long sum = 0;
        HashMap<Long, Integer> map = new HashMap();
        map.put(0L, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum-k))
                res += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}

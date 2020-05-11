package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by csy99 on 4/16/20.
 */
public class Q368_Largest_Divisible_Subset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] cnt = new int[n];
        int[] pre = new int[n];
        int max = 0;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            pre[i] = -1;
            cnt[i] = 1;
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && 1 + cnt[j] > cnt[i]) {
                    cnt[i] = cnt[j] + 1;
                    pre[i] = j;
                }
            }
            if (cnt[i] > max) {
                max = cnt[i];
                idx = i;
            }
        }
        List<Integer> res = new ArrayList();
        while (idx != -1) {
            res.add(nums[idx]);
            idx = pre[idx];
        }
        return res;
    }
}

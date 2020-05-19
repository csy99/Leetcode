package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by csy99 on 4/15/20.
 */
public class Q015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> zero = new ArrayList();
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > 0)  // pruning
                break;
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int l = i+1;
            int r = nums.length-1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ArrayList<Integer> tmp = new ArrayList();
                    tmp.add(nums[i]);
                    tmp.add(nums[l]);
                    tmp.add(nums[r]);
                    zero.add(tmp);
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l-1])
                        l++;
                    while (l < r && nums[r] == nums[r+1])
                        r--;
                } else if (sum < 0)
                    l++;
                else
                    r--;
            }
        }
        return zero;
    }
}

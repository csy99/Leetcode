package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 9/1/20.
 */
public class Q448_Find_All_Numbers_Disappeared_in_an_Array {
    // adjust the position of each value
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i+1) {
                int idx = nums[i]-1;
                if (nums[idx] == nums[i])
                    break;
                int tmp = nums[idx];
                nums[idx] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i+1)
                res.add(i+1);
        }
        return res;
    }
    
    // label
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0)
                nums[idx] = -nums[idx];
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                res.add(i+1);
        }
        return res;
    }
}

package Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by csy99 on 4/15/20.
 */
public class Q018_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 3)
            return res;
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            List<List<Integer>> element = threeSum(nums, target-nums[i], i+1);
            for (int j = 0; j < element.size(); j++) {
                List<Integer> sol = element.get(j);
                sol.add(0, nums[i]);
                res.add(sol);
            }
            i++;
            while (i < nums.length && nums[i] == nums[i-1])
                i++;
        }
        return res;
    }
    
    public List<List<Integer>> threeSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int i = start; 
        while (i + 2 < nums.length) {
            int base = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = base + nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> sol = new ArrayList();
                    sol.add(base);
                    sol.add(nums[left]);
                    sol.add(nums[right]);
                    res.add(sol);
                    left = moveLeft(nums, left+1);
                    right = moveRight(nums, right-1);
                } else if (sum > target) 
                    right = moveRight(nums, right-1);
                else
                    left = moveLeft(nums, left+1);
            }
            i = moveLeft(nums, i+1);
        }
        return res;
    }
    
    private int moveLeft(int[] nums, int left) {
        while (left < nums.length && nums[left] == nums[left-1])
            left++;
        return left;
    }
    
    private int moveRight(int[] nums, int right) {
        while (right >= 0 && nums[right] == nums[right+1])
            right--;
        return right;
    }
}

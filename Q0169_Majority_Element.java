package Leetcode;

/**
 * Created by csy99 on 5/20/20.
 */
public class Q169_Majority_Element {
    // divide and conquer
    // time: avg O(n), worst(n*log n)
    public int majorityElement(int[] nums) {
        return findLarger(nums, 0, nums.length-1)[0];
    }
    
    // the first return value is the most frequent element, the second return value its counts
    private int[] findLarger(int[] nums, int l, int r) {
        if (l == r) 
            return new int[] {nums[l], 1};
        int mid = ((r - l) >> 1) + l;
        int[] first = findLarger(nums, l, mid);
        int[] second = findLarger(nums, mid+1, r);
        // the most freq element is the same in two ranges
        if (first[0] == second[0])
            return new int[] {first[0], first[1]+second[1]};
        // the line below cannot change from ">" to ">=", otherwise won't pass the case [6,5,5].
        // Think in this way (an intuition not a proof): The length of the first half is larger than or equal to that of the second half, it should have absolute advantage
        if (first[1] > second[1])
            return new int[] {first[0], first[1]+count(nums, mid+1, r, first[0])};
        else
            return new int[] {second[0], second[1]+count(nums, l, mid, second[0])};
    }
    
    private int count(int[] nums, int l, int r, int val) {
        int cnt = 0;
        for (int i = l; i < r+1; i++)
            if (nums[i] == val)
                cnt++;
        return cnt;
    }
    
    
    // sort
    // time: O(n*logn)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
 
    // math
    // time: O(n)
    // space: O(1)
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 0;

        for (int i: nums) {
            if (i == majority)
                 count++;
            else {
                 count--;
                 if (count == 0) {
                     majority = i;
                     count = 1;
                 }
            }
        }
        return majority;
    }
    
    
}

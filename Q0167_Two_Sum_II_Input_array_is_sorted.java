package Leetcode;

/**
 * Created by csy99 on 4/15/20.
 */
public class Q167_Two_Sum_II_Input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0; 
        int r = numbers.length-1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target)
                break;
            if (numbers[l] + numbers[r] < target)
                l++;
            else
                r--;
        }
        return new int[] {l+1, r+1};  // 1-based index
    }
}

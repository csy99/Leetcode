import java.util.HashMap;
import java.util.Map;

/**
 * Created by csy99 on 4/15/20.
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 */
public class Q001_Two_Sum {

    // sort
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] backup = Arrays.copyOf(nums, len);
        Arrays.sort(nums);

        int front = 0;
        int back = len - 1;
        while (front < back) {
            if (nums[front] + nums[back] == target)
                break;
            else if (nums[front] + nums[back] < target)
                front++;
            else
                back--;
        }
        int li[] = new int[2];
        boolean found = false;
        for (int j = 0; j < len; j++) {
            if (li[0] != 0 && li[1] != 0) {
                break;
            }
            if (backup[j] == nums[front] && !found) {
                li[0] = j;
                found = true;
            } else if (backup[j] == nums[back]) {
                li[1] = j;
            }
        }
        return li;
    }
    
    // HashMap
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            // same element cannot be used twice
            if (map.containsKey(remainder) && i != map.get(remainder))
                return new int[]{i, map.get(remainder)};
        }
        return new int[] {};
    }
    
    public static void main(String[] args) {
        Q001_Two_Sum sol = new Q001_Two_Sum();

        int[] arr = {1, 2, 3, 4, 5};
        int target = 7;

        int[] result = sol.twoSum(arr, target);
        System.out.println("Indices "+ result[0] + " and " + result[1] +
                " with values " + arr[result[0]] + " and " + arr[result[1]] + " add upto " +
                target);
    }
}

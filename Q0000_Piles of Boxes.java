/**
 * Created by csy99 on 8/31/21.
 You are given an array of heights of pile of boxes. You have to return the number of steps required to bring the height of entire pile to the same height as pile with minimum height. In one step, you can lower the tallest pile only to the next taller pile. You can adjust only one pile in a step even though 2 piles could be of same height. Following examples will illustrate this better,

Example 1:

Input: arrOfHeights = [150, 210, 210, 80, 110]
Output: 9
Explanation:
Step 1 [150, 150, 210, 80, 110]
Step 2 [150, 150, 150, 80, 110]
Step 3 [110, 150, 150, 80, 110]
Step 4 [110, 110, 150, 80, 110]
Step 5 [110, 110, 110, 80, 110]
Step 6 [80, 110, 110, 80, 110]
Step 7 [80, 80, 110, 80, 110]
Step 8 [80, 80, 80, 80, 110]
Step 9 [80, 80, 80, 80, 80]
Example 2:

Input: arrOfHeights = [843, 247]
Output: 1
Explanation:
Step 1 [247, 247]
Example 3:

Input: arrOfHeights = [2]
Output: 0
 */

public class Solution {
    public int getStep(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n-1; i++) {
            if (nums[i+1] != nums[i])
                res += n - i - 1;
        }
        return res;
    }
}

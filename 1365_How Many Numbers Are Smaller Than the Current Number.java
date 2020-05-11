/*
 * Created by csy99 on 2/29/20 during competition.
1365. How Many Numbers Are Smaller Than the Current Number
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. 
That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
Return the answer in an array.

Constraints:
2 <= nums.length <= 500
0 <= nums[i] <= 100

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).

Input: nums = [7,7,7,7]
Output: [0,0,0,0]
*/
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
      int[] cnt = new int[101];
      int max = 0;  // the max number in arr
      for (int i = 0; i < nums.length; i++) {  // count for each number in arr
        cnt[nums[i]] += 1;
        if (nums[i] > max)
          max = nums[i];
      }
      
      int[] small = new int[max + 1];  // count for number smaller
      small[0] = 0;  // nothing will be smaller
      for (int i = 1; i < max + 1; i++) {
        small[i] = small[i-1] + cnt[i-1];
      }
      
      int[] res = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
        res[i] = small[nums[i]];
      }
        
      return res;
    }
}

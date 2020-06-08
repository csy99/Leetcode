package Leetcode;

/**
 * Created by csy99 on 3/9/20.
 */
public class Q287_Find_the_Duplicate_Number {
    // linked list, cycle detection 
    // time: O(n), space:O(1)
    public int findDuplicate(int[] nums) {
      int slow = nums[0];
      int fast = nums[0];
      do {
        slow = nums[slow];
        fast = nums[fast];
        fast = nums[fast];
      } while (slow != fast);
      
      fast = nums[0];
      while (slow != fast) {
        slow = nums[slow];
        fast = nums[fast];
      } 
      
      return fast;
    }
    
    
    // binary search
    // time: O(n logn), space:O(1)
    public int findDuplicate(int[] nums) {
        int n = nums.length-1;
        int left = 1;
        int right = n;
        while (left < right) {
            int cntLeft = 0;
            int cntMid = 0;
            int mid = (left+right)/2;
            for (int num: nums) {
                if (num < mid)
                    cntLeft++;
                else if (num == mid)
                    cntMid++;
            }
            if (cntMid > 1) return mid;
            if (cntLeft > mid-1)  // the dup value is smaller than mid
                right = mid;
            else
                left = mid+1;
        }
        return left;
    }
    
    // two traversals (modified the array)
    // time: O(n), space:O(1)
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num-1 == i) continue;
            if (nums[num-1] == num)
                return num;
            int tmp = nums[num-1];
            nums[num-1] = nums[i];
            nums[i] = tmp;
        }
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num-1 == i) continue;
            if (nums[num-1] == num)
                return num;
            int tmp = nums[num-1];
            nums[num-1] = nums[i];
            nums[i] = tmp;
        }
        return -1;
    }
}

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
      int len = nums.length;
      int n = len - 1;
      
      int left = 1;
      int right = n;
      while (left < right) {
        int mid = left + (right - left)/2;
        int countLeft = 0;
        int countMid = 0;
        for (int i = 0; i < len; i++) {
          if (nums[i] < mid)
            countLeft++;
          else if (nums[i] == mid)
            countMid++;
        }
        if (countMid > 1)
          return mid;
        if (countLeft > mid - 1) {  // the dup value is smaller than mid
          right = mid - 1;
        } else {
          left = mid + 1;
        }
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

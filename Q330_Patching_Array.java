package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q330_Patching_Array {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int count = 0;
        int i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss = miss + nums[i];
                i++;
            } else {
                miss += miss;
                count++;
            }
        }

        return count;
    }
    
/**
 * Created by csy99 on 3/9/20.
 */    
    public int minPatches(int[] nums, int n) {
      long pre_sum = 0;
      int patch = 0; 
      for (int i = 0; i < nums.length && pre_sum < n; i++) {
        while (pre_sum + 1 < nums[i] && pre_sum < n) {  // a gap
          patch++;
          pre_sum += (pre_sum + 1);
        }
        pre_sum += nums[i];
      }
      while (pre_sum < n) {  // not able to accomplish the task after using all the numbers
        patch++;
        pre_sum += (pre_sum + 1);
      }
      return patch;
    }
}

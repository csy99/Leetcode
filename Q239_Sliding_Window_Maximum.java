package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by csy99 on 3/15/20.
 */
public class Q239_Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
      if (k <= 1)
        return nums;
      int[] res = new int[nums.length - k + 1];  
      LinkedList<Integer> doubleQueue = new LinkedList<>();
      for (int i = 0; i < nums.length; i++) {
        while (!doubleQueue.isEmpty() && nums[i] >= nums[doubleQueue.getLast()])
          doubleQueue.removeLast();
        doubleQueue.add(i);
        if (i+1-k >= 0) {  // first valid window 
          res[i+1-k] = nums[doubleQueue.getFirst()];
          if (i+1-k >= doubleQueue.getFirst())
            doubleQueue.removeFirst();
        }
      }
      return res;
    }
}

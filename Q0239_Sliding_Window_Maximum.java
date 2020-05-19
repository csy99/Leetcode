package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by csy99 on 3/15/20.
 */
public class Q239_Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) return nums;
        int[] res = new int[nums.length-k+1];
        Deque<Integer> idx = new LinkedList();
        for (int i = 0;  i < nums.length; i++) {
            while (idx.size() > 0 && nums[i] >= nums[idx.getLast()])
                idx.removeLast();
            idx.addLast(i);
            if (i-k+1 >= 0) {
                res[i-k+1] = nums[idx.getFirst()];
                if (i-k+1 >= idx.getFirst())
                    idx.removeFirst();
            }
        }
        return res;
    }
}

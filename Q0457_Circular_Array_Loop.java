package Leetcode;

/**
 * Created by csy99 on 9/1/20.
 */
public class Q457_Circular_Array_Loop {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;
        for (int i = 0; i < n; i++) {
            int slow = i;
            int fast = i;
            boolean forward = nums[i] > 0;
            while (true) {
                slow = getNext(nums, slow, forward);
                if (slow == -1) break;

                fast = getNext(nums, fast, forward);
                if (fast == -1) break;

                fast = getNext(nums, fast, forward);
                if (fast == -1) break;
                
                if (slow == fast)
                    return true;
            }
        }
            
        return false;
    }
    
    private int getNext(int[] nums, int idx, boolean forward) {
        boolean dir = nums[idx] > 0;
        if (forward != dir)
            return -1;
        int nxt = (idx + nums[idx]) % nums.length;
        if (nxt < 0)
            nxt += nums.length;
        if (nxt == idx) return -1;
        return nxt;
    }
}

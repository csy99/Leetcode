/**
 * Created by csy99 on 8/30/20.
 */
public class Solution {
    // traversal, time: O(n), space: O(1)
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int longest = 0;
        int first_neg_idx = -1;
        int zero_idx = -1;
        int negs = 0;
        for (int i = 0; i < n; i++) {
            // if current number is 0, we can't use any element from index 0 to i anymore
            if (nums[i] == 0) {  
                first_neg_idx = -1;
                zero_idx = i;
                negs = 0;
            } else {
                if (nums[i] < 0) {
                    if (first_neg_idx < 0)
                        first_neg_idx = i;
                    negs++;
                }
                if (negs % 2 == 0)
                    longest = Math.max(longest, i - zero_idx);
                else
                    longest = Math.max(longest, i - first_neg_idx);
            }
        }
        return longest;
    }
    
    
    // dp, time: O(n^2), space: O(n), TLE
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int longest = 0;
        int[] prod = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                longest = 1;
                prod[i] = 1;
            } else if (nums[i] < 0)
                prod[i] = -1;
        }
        for (int len = 2; len <= n; len++) {
            for (int start = 0; start+len <= n; start++) {
                int end = start+len-1;
                int num1 = 0;
                if (prod[start] > 0)
                    num1 = 1;
                else if (prod[start] < 0)
                    num1 = -1;
                prod[start] = num1 * nums[end];
                if (prod[start] > 0)
                    longest = Math.max(longest, len);
            }
        }
        return longest;
    }
}

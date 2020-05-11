package Leetcode;

/**
 * Created by csy99 on 4/18/20.
 */
public class Q260_Single_Number_III {
    // suppose the return value should be [a,b]
    // a != b, so a XOR b != 0
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        // get a XOR b
        for (int i = 0; i < nums.length; i++) 
            diff ^= nums[i];
        // Get its last set bit
        diff &= -diff;
        int[] res = new int[]{0, 0};
        // Partition the numbers into two groups based on the bit that a and b are different
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & diff) == 0)
                res[0] ^= nums[i];
            else
                res[1] ^= nums[i];
        }
        return res;
    }
}

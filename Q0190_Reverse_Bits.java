package Leetcode;

/**
 * Created by csy99 on 4/18/20.
 */
public class Q190_Reverse_Bits {
    // you need treat n as an unsigned value
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // in round i, (n & 1) extracts the i-th digit from the end
            res = (res << 1) | (n & 1);
            n >>= 1;
        }
        return res;
    }
}

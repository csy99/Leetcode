package Leetcode;

/**
 * Created by csy99 on 4/18/20.
 */
public class Q190_Reverse_Bits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n >>>= 1;
            if (i < 31)
                res <<= 1;
        }
        return res;
    }
}

package Leetcode;

/**
 * Created by csy99 on 4/18/20.
 */
public class Q191_Number_of_1_Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
    
    public int hammingWeight(int n) {
        int bits = 0;
        while (n != 0) {
            bits++;
            n &= (n-1);  // n AND n−1 flips the LSB in n to 0
        }
        return bits;
    }
}

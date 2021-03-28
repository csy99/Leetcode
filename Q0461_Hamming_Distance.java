package Leetcode;

/**
 * Created by csy99 on 3/28/21.
 * <p>
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 */
public class Q461_Hamming_Distance {
    public int hammingDistance(int x, int y) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int a = x & 1;
            int b = y & 1;
            if (a != b) res++;
            x >>>= 1;
            y >>>= 1;
        }
        return res;
    }
}

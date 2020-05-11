package Leetcode;

/**
 * Created by csy99 on 4/15/20.
 */
public class Q326_Power_of_Three {
    public boolean isPowerOfThree(int n) {
        double a = Math.log(n) / Math.log(3);
        return Math.abs(a - Math.rint(a)) <= 0.00000000000001;
    }
    
}

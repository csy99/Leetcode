package Leetcode;

/**
 * Created by csy99 on 4/13/20.
 * <p>
 * https://leetcode.com/problems/powx-n/
 */
public class Q050_Pow {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1)
            return 1;
        if (n < 0)
            return 1 / (x*myPow(x, -(n+1)));
        double res = 1;
        while (n > 1) {
            if (n % 2 == 1) {
                res *= x;
                n--;
            }
            x = x * x;
            n /= 2;
        }
        res *= x;
        return res;
    }
}

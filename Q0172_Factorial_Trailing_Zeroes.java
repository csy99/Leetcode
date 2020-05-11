package Leetcode;

/**
 * Created by csy99 on 4/15/20.
 */
public class Q172_Factorial_Trailing_Zeroes {
    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n >= 5) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }
}

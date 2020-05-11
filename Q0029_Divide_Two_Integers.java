package Leetcode;

/**
 * Created by csy99 on 4/13/20.
 */
public class Q029_Divide_Two_Integers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1)
                return Integer.MAX_VALUE;
            if (divisor == 1)
                return Integer.MIN_VALUE;
        }
        long divd = dividend;
        long divs = divisor;
        int sign = 1;
        int res = 0;
        if (divd < 0) {
            divd = -divd;
            sign = -sign;
        }
        if (divs < 0) {
            divs = -divs;
            sign = -sign;
        }
        while (divd >= divs) {
            int shift = 0;
            while (divd >= divs << shift) 
                shift++;
            res += (1 << (shift - 1));
            divd -= (divs << (shift - 1));
        }
        return sign * res;
    }

    public static void main(String[] args) {
        Q029_Divide_Two_Integers sol = new Q029_Divide_Two_Integers();
        int res = sol.divide(-1, 1);
        System.out.println(res);
    }
}

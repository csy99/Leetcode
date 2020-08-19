package Leetcode;

/**
 * Created by csy99 on 4/15/20.
 */
public class Q400_Nth_Digit {
    public int findNthDigit(int n) {
        long start = 1;
        long end = 9;
        int digits = 1;
        // find tiers
        while (n > (end-start+1)*digits) {
            n -= (end-start+1)*digits;
            start *= 10;
            end = end * 10 + 9;
            digits++;
        }
        // find numbers
        int t = (n - 1) / digits;
        n -= t * digits;
        start += t;
        // find digits
        String tmp = String.valueOf(start);
        return tmp.charAt(n-1) - '0';
    }
}

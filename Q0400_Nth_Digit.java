package Leetcode;

/**
 * Created by csy99 on 4/15/20.
 */
public class Q400_Nth_Digit {
    public int findNthDigit(int n) {
        long digits = 9;
        int len = 1;
        int first = 1;
        while (n > len * digits) {
            n -= len * digits;
            len++;
            first *= 10;
            digits *= 10; 
        }
        
        first += (n-1) / len;
        String num = Integer.toString(first);
        return (int)(num.charAt((n-1)%len) - '0');
    }
}

package Leetcode;

/**
 * Created by csy99 on 4/15/20.
 */
public class Q233_Number_of_Digit_One {
    public int countDigitOne(int n) {
        int num = n;
        int cnt = 0;
        int factor = 1;
        while (n > 0) {
            int m = n/10;
            int r = n%10;
            int amount;
            if (r == 0)
                amount = 0;
            else if (r > 1)
                amount = factor;
            else
                amount = num%factor + 1;
            cnt += m * factor + amount;
            n /= 10;
            factor *= 10;
        }
        return cnt;
    }
}

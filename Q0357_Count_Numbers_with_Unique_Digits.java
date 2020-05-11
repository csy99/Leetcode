package Leetcode;

/**
 * Created by csy99 on 4/16/20.
 */
public class Q357_Count_Numbers_with_Unique_Digits {
    // f(0) = 1
    // f(1) = 9
    // f(2) = 9*9!/9!
    // f(3) = 9*9!/8!
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            int cur = 9;
            for (int factor = 9; factor > 10 - i; factor--)
                cur *= factor;
            cnt += cur;
        }
        return cnt;
    }
}

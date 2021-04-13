package Leetcode;

/**
 * Created by csy99 on 4/12/21.
 */
public class Q507_Perfect_Number {
    public boolean checkPerfectNumber(int num) {
        if (num < 2) return false;
        int res = 0;
        for (int divisor = 1; divisor*divisor <= num; divisor++) {
            if (num % divisor == 0) {
                res += divisor;
                if (divisor * divisor != num)
                    res += num / divisor;
                // System.out.printf("div:%d, res:%d\n",divisor, res);
            }
        }
        return res == 2*num;
    }
}

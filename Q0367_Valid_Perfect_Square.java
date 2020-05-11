package Leetcode;

/**
 * Created by csy99 on 4/15/20.
 */
public class Q367_Valid_Perfect_Square {
    public boolean isPerfectSquare(int num) {
        long l = 1;
        long r = num;
        while (l < r) {
            long mid = l +(r - l) / 2;
            if (mid*mid == num)
                return true;
            if (mid*mid > num)
                r = mid;
            else
                l = mid+1;
        }
        return l == num;
    }
}

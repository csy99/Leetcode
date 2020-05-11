package Leetcode;

/**
 * Created by csy99 on 4/13/20.
 *
 * Since the return type is an integer,
 * the decimal digits are truncated and only the integer part of the result is returned.
 */
public class Q069_Sqrt_x {

    // Newton's method
    // gradient descent
    public int mySqrt(int x) {
        long res = x;
        while (res * res > x) 
            res = (res + x / res) / 2;
        return (int)res;
    }
    
    // Binary Search
    public int mySqrt(int x) {
        int l = 1;
        int r = x;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid == x / mid)
                return mid;
            if (mid > x / mid)
                r = mid;
            else
                l = mid + 1;
        } 
        if (l > x / l)
            return l - 1;
        return l;
    }

    public static void main(String[] args) {
        Q069_Sqrt_x sol = new Q069_Sqrt_x();
        double num = 3.0;
        double ans = sol.sqrt(num);
        System.out.println(ans);
    }
}

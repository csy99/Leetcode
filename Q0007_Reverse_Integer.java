package Leetcode;

/**
 * Created by csy99 on 4/13/20.
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 *
 */
public class Q007_Reverse_Integer {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            // get the next LSB
            int nxt = rev * 10 + x % 10;
            // check overflow
            if ((nxt-x%10)/10 != rev)
                return 0;
            rev = nxt;
            x /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        Q007_Reverse_Integer sol = new Q007_Reverse_Integer();
        int result = sol.reverse(123);
        System.out.println("Result: "  + result);
    }
}

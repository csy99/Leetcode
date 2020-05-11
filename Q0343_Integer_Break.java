package Leetcode;

/**
 * Created by csy99 on 4/15/20.
 */
public class Q343_Integer_Break {
    public int integerBreak(int n) {
        int[] max = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j <= i; j++) {
                max[i] = Math.max(max[i], max[j]*(i-j));
                max[i] = Math.max(max[i], (i-j)*j);
            }
        }
        return max[n];
    }

    public int integerBreakTwo(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }

        if (n == 4) {
            return 4;
        }

        int result = 1;

        while (n > 4) {
            result *= 3;
            n -= 3;
        }

        result *= n;
        return result;
    }

    public static void main(String[] args) {
        Q343_Integer_Break sol = new Q343_Integer_Break();
        int n = 10;
        int res = sol.integerBreak(n);
        System.out.println(res);

    }
}

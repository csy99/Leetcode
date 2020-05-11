package Leetcode;

/**
 * Created by csy99 on 4/16/20.
 */
public class Q397_Integer_Replacement {
    // MLE
    // public int integerReplacement(int n) {
    //     int[] steps = new int[n+1];
    //     steps[1] = 0;
    //     for (int i = 2; i <= n; i++) {
    //         if (i % 2 == 0)
    //             steps[i] = steps[i/2] + 1;
    //         else
    //             steps[i] = Math.min(steps[i-1], steps[(i+1)/2]+1) + 1;
    //     }
    //     return steps[n];
    // }
    
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE)
            return 32;
        int steps = 0;
        while (n > 1) {
            if (n % 2 == 0)
                n /= 2;
            else {
                if ((n+1)%4 == 0 && n != 3)
                    n++;
                else
                    n--;
            }
            steps++;
        }
        return steps;
    }
}

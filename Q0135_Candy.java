package Leetcode;

/**
 * Created by csy99 on 3/9/20.
 */
public class Q135_Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;
        int[] candy = new int[n];
        candy[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1])
                candy[i] = candy[i-1]+1;
            else
                candy[i] = 1;
        }
        for (int i = n-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1])
                candy[i] = Math.max(candy[i+1]+1, candy[i]);
        }
        int res = 0;
        for (int c: candy)
            res += c;
        return res;
    }
}

package Leetcode;

/**
 * Created by csy99 on 8/31/20.
 */
public class Q441_Arranging_Coins {
    public int arrangeCoins(int n) {
        double rt = Math.floor(Math.sqrt(2.0*n));
        if (rt*(rt+1)/2 <= n)
            return (int)rt;
        return (int)rt-1;
    }
}

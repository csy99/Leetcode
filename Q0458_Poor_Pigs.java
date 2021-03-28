package Leetcode;
/**
 * Created by csy99 on 3/28/21.
 */
public class Q458_Poor_Pigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int round = minutesToTest / minutesToDie;
        int res = 0;
        while (Math.pow(round+1, res) < (double) buckets)
            res++;
        return res;
    }
}

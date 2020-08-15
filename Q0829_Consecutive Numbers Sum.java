/**
 * Created by csy99 on 8/14/20.
 */
class Solution {
    public int consecutiveNumbersSum(int num) {
        int res = 0;
        for (int len = 1; len < num; len++) {
            if (len * (len+1) >= 2 * num) break;
            double eps = 1e-7;
            double tmp = (1.0*num - len*(len+1)/2.0) / (len+1);
            if (tmp - (int) tmp > eps) continue;
            res++;
        }
        return res + 1;
    }
}

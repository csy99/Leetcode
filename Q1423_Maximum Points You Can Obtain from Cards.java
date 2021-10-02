/**
 * Created by csy99 on 10/2/21.
 */
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        int r = 0;
        int l = 0;
        for (; r < k; r++)
            sum += cardPoints[r];
        r--;
        int res = sum;
        for (int i = 0; i < k; i++) {
            sum -= cardPoints[r];
            sum += cardPoints[n-l-1];
            res = Math.max(res, sum);
            r--;
            l++;
        }
        return res;
    }
}

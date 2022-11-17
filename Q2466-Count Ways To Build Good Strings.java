/**
 * Created by csy99 on 11/16/22.
 */
// dp
// time: O(high), space: O(high)
class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int kmod = (int)1e9 + 7;
        long[] counts = new long[high+1];
        counts[zero] += 1;
        counts[one] += 1;
        int start = Math.min(zero, one);
        for (int i = start+1; i <= high; i++) {
            if (i - zero >= 0)
                counts[i] += counts[i-zero];
            if (i - one >= 0)
                counts[i] += counts[i-one];
            counts[i] %= kmod;
        }
        long res = 0;
        for (int i = low; i <= high; i++) {
            res += counts[i];
            res %= kmod;
        }
        return (int)res;
    }
}

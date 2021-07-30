/**
 * Created by csy99 on 7/30/21.
 */
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] freqs = new int[60];
        for (int t: time) {
            int mod = t % 60;
            freqs[mod]++;
        }
        int res = freqs[0] * (freqs[0]-1) / 2;
        res += freqs[30] * (freqs[30]-1) / 2;
        for (int f = 1; f < 30; f++)
            res += freqs[f] * freqs[60-f];
        return res;
    }
}

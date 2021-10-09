/**
 * Created by csy99 on 10/9/21.
 */
class Solution {
    public int concatenatedBinary(int n) {
        final int kmod = (int)1e9+7;
        long res = 0;
        int bitLength = 1;
        int nextLevel = 2;
        for (int i = 1; i <= n; i++) {
            if (i == nextLevel) {
                nextLevel *= 2;
                bitLength++;
            }
            res = (res << bitLength) | i;
            res %= kmod;
        }
        return (int)res;
    }
}

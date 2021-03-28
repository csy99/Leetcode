/**
 * Created by csy99 on 3/28/21.
 */
// n = 3 * (n - 3)
class Solution {
    public int maxNiceDivisors(int n) {
        int kmod = (int)1e9+7;
        int[] arr = new int[]{0,1,2,3,4,6};
        if (n < 6) return arr[n];
        return (int) (modpow(3, n/3-1, kmod) * arr[3+n%3] % kmod);
    }
    
    private long modpow(long base, int exp, int mod) {
        long res = 1;
        for (; exp > 0; exp >>= 1) {
            if ((exp&1) == 1)
                res = res * base % mod;
            base = base * base % mod;
        }
        return res;
   }
}

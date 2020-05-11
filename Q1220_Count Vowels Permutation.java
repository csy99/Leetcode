/**
 * Created by csy99 on 5/7/20. 
 */
class Solution {
    // dp
    public int countVowelPermutation(int n) {
        int kMod = 1_000_000_007;
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        for (int r = 2; r <= n; r++) {
            long aa = (e + i + u) % kMod;
            long ee = (a + i) % kMod;
            long ii = (o + e) % kMod;
            long oo = i % kMod;
            long uu = (o + i) % kMod;
            a = aa;
            e = ee;
            i = ii;
            o = oo;
            u = uu;
        }
        return (int)((a + e + i + o + u) % kMod);
    }
    
    // another way to approach the problem is through matrix multiplication. 
}

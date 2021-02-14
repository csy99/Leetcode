/**
 * Created by csy99 on 2/13/21 during contest.
 */
class Solution {
    public int countHomogenous(String s) {
        int mod = (int)1e9 + 7;
        long res = 0;
        int n = s.length();
        char prev = '*';
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == prev)
                cnt++;
            else {
                long cur = (long) cnt * (cnt+1) / 2;
                res += cur;
                prev = c;
                cnt = 1;
                res %= mod;
            }
        }
        long cur = (long) cnt * (cnt+1) / 2;
        res += cur;
        res %= mod;
        return (int) res;
    }
}

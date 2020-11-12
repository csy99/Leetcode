/**
 * Created by csy99 on 11/12/20.
 */
class Solution {
    public int maxPower(String s) {
        int n = s.length();
        int i = 0;
        int res = 0;
        int cur = 0;
        char prev = ' ';
        while (i < n) {
            char c = s.charAt(i);
            if (c == prev)
                cur++;
            else {
                prev = c;
                cur = 1;
            }
            res = Math.max(res, cur);
            i++;
        }
        return res;
    }
}

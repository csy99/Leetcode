/**
 * Created by csy99 on 5/29/20.
 */
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int m = name.length();
        int n = typed.length();
        if (m == 0 || m > n) return false;
        int p = 0;
        int q = 0;
        while (p < m && q < n) {
            if (name.charAt(p) == typed.charAt(q)) {
                p++;
                q++;
            } else if (q > 0 && typed.charAt(q) == typed.charAt(q-1))
                q++;
            else
                return false;
        }
        while (q < n && typed.charAt(q) == typed.charAt(q-1))
            q++;
        return p == m && q == n;
    }
}

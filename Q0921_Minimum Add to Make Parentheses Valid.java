/**
 * Created by csy99 on 9/20/20.
 */
class Solution {
    public int minAddToMakeValid(String S) {
        int n = S.length();
        int res = 0;
        int bal = 0;
        for (int i = 0; i < n; i++) {
            bal += S.charAt(i) == '(' 1 : -1;
            if (bal == -1) {
                res++;
                bal++;
            }
        }
        return res + bal;
    }
}

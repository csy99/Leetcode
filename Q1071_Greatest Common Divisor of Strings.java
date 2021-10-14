/**
 * Created by csy99 on 10/13/21.
 */
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        if (m > n) return gcdOfStrings(str2, str1);
        String res = "";
        for (int i = m-1; i >= 0; i--) {
            if (m % (i+1) != 0)
                continue;
            String sub = str1.substring(0, i+1);
            if (!valid(sub, str1) || !valid(sub, str2)) continue;
            res = sub;
            break;
        }
        return res;
    }
    
    private boolean valid(String pat, String text) {
        int m = pat.length();
        int n = text.length();
        if (n % m != 0) return false;
        for (int i = 0; i < n; i += m) {
            if (!text.substring(i, i+m).equals(pat))
                return false;
        }
        return true;
    }
}

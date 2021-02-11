/**
 * Created by csy99 on 2/11/21.
 */
class Solution {
    public String removeOuterParentheses(String S) {
        int n = S.length();
        if (n == 0 || n == 2) return "";
        char[] arr = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder cur = new StringBuilder();
        int l = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            cur.append(arr[i]);
            if (arr[i] == '(')
                l++;
            else
                r++;
            if (l > 0 && l == r) {
                cur.deleteCharAt(0);
                cur.deleteCharAt(cur.length()-1);
                sb.append(cur.toString());
                cur.setLength(0);
                l = 0;
                r = 0;
            }
        }
        return sb.toString();
    }
}

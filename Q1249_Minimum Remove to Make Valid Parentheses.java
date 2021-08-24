/**
 * Created by csy99 on 8/23/21.
 */
 // greedy, time: O(n), space: O(n)
class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        int l = 0;
        int i = 0;
        while (i < sb.length()) {
            char c = sb.charAt(i);
            if (c == ')') {
                if (l == 0) {
                    sb.deleteCharAt(i);
                    i--;
                } else
                    l--;
            } else if (c == '(')
                l++;
            i++;
        }
        i--;
        while (l > 0 && i >= 0) {
            char c = sb.charAt(i);
            if (c == '(') {
                sb.deleteCharAt(i);
                l--;
            }
            i--;
        }
        return sb.toString();
    }
}

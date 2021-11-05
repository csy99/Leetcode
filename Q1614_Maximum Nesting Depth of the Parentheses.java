/**
 * Created by csy99 on 11/5/21.
 */
class Solution {
    public int maxDepth(String s) {
        int res = 0;
        int cur = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') cur++;
            else if (c == ')') cur--;
            res = Math.max(res, cur);
        }
        return res;
    }
}

/**
 * Created by csy99 on 9/21/20.
 */
class Solution {
    int res = 1;
    public int maxUniqueSplit(String s) {
        helper(s, new HashSet());
        return res;
    }
    
    private void helper(String s, HashSet<String> seen) {
        int n = s.length();
        if (n == 0) {
            res = Math.max(res, seen.size());
            return;
        }
        for (int len = 1; len <= n; len++) {
            String first = s.substring(0, len);
            if (seen.contains(first))
                continue;
            seen.add(first);
            helper(s.substring(len), seen);
            seen.remove(first);
        }
    }
}

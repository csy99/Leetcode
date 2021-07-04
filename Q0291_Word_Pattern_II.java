package Leetcode;

/**
 * Created by csy99 on 7/4/21.
 */
public class Solution {
    int m;
    int n;
    String pattern;
    String str;
    boolean res = false;
    public boolean wordPatternMatch(String pattern, String str) {
        m = pattern.length();
        n = str.length();
        this.pattern = pattern;
        this.str = str;
        helper(0, 0, new HashMap(), new HashSet());
        return res;
    }

    private void helper(int p, int q, Map<Character, String> dict, Set<String> seen) {
        if (p == m && q == n) {
            res = true;
            return;
        }
        if (p == m || q == n) return;
        if (res) return;
        char pc = pattern.charAt(p);
        if (dict.containsKey(pc)) {
            String val = dict.get(pc);
            int nq = q + val.length();
            if (nq > n || !str.substring(q, nq).equals(val)) 
                return;
            helper(p+1, nq, dict, seen);
        } else {
            for (int i = q; i < n; i++) {
                String candidate = str.substring(q, i+1);
                if (seen.contains(candidate)) continue;
                dict.put(pc, candidate);
                seen.add(candidate);
                helper(p+1, q+candidate.length(), dict, seen);
                dict.remove(pc);
                seen.remove(candidate);
            }
        }
    }
}

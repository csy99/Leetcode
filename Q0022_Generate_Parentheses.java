package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/20/20.
 * <p>
 * Given n pairs of parentheses,
 * write a function to generate all combinations of well-formed parentheses.
 */
public class Q022_Generate_Parentheses {
    List<String> res = new ArrayList();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        if (n == 0) return res;
        dfs(n, n, new StringBuilder());
        return res;
    }
    
    private void dfs(int pos, int neg, StringBuilder sb) {
        if (sb.length() == 2*n) {
            res.add(sb.toString());
            return;
        }
        int len = sb.length();
        if (pos > 0) {
            sb.append("(");
            dfs(pos-1, neg, sb);
            sb.setLength(len);
        }
        if (neg > 0 && neg > pos) {  // more left parathesis should appear first
            sb.append(")");
            dfs(pos, neg-1, sb);
            sb.setLength(len);
        }
    }
}

package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/21/20.
 */
public class Q131_Palindrome_Partitioning {
    // dp
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList();
        dp[0].add(new ArrayList());
        for (int r = 1; r < n + 1; r++) { // end before r
            for (int l = 0; l < r; l++) { // starting at l
                String cur = s.substring(l, r);
                if (!isPali(cur) || dp[l] == null)
                    continue;
                
                List<List<String>> part = null;
                if (dp[r] == null)
                    part = new ArrayList();
                else
                    part = dp[r];
                for (int k = 0; k < dp[l].size(); k++) {
                    List<String> element = new ArrayList(dp[l].get(k));
                    element.add(cur);
                    part.add(element);
                }
                dp[r] = part;
            }
        }
        return dp[n];
    }

    private boolean isPali(String s) {
        if (s.isEmpty())
            return true;
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
  
    // backtracking
    List<List<String>> res = new ArrayList();
    String str;
    public List<List<String>> partition(String s) {
        str = s;
        dfs(new ArrayList(), 0);
        return res;
    }
    
    private void dfs(List<String> path, int start) {
        if (start == str.length()) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = 1; i+start <= str.length(); i++) {
            String sub = str.substring(start, start+i);
            if (!isPa(sub)) continue;
            path.add(sub);
            dfs(path, start+i);
            path.remove(path.size()-1);
        }
    }
}

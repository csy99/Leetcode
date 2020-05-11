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
  
  
  public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    boolean[][] pali = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) 
      pali[i][i] = true;
    for (int i = 0; i < s.length() - 1; i++)
      pali[i][i+1] = s.charAt(i) == s.charAt(i+1);
    for (int l = 3; l < s.length() + 1; l++) {
      for (int i = 0; i < s.length()-l+1; i++) {
        if (s.charAt(i) == s.charAt(i+l-1) && pali[i+1][i+l-2])
          pali[i][i+l-1] = true;
      }
    }
    backTrack(s, res, new LinkedList(), pali, 0);
    return res;
  }
  
  private void backTrack(String s, List<List<String>> res, LinkedList<String> part, 
                        boolean[][] pali, int start) {
    if (s.length() == start) { // traverse through all chars in string s
      res.add(new LinkedList<String> (part));
      return;
    }
    
    for (int end = 0; end < s.length(); end++) {
      if (pali[start][end]) {
        part.add(s.substring(start, end+1));
        backTrack(s, res, part, pali, end+1);
        part.removeLast();
      }
    }
  }
}

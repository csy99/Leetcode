package Leetcode;

/**
 * Created by csy99 on 3/21/20.
 */
public class Q132_Palindrome_Partitioning_II {
      public int minCut(String s) {
        int n = s.length();
        // isPa[i][j]: check if s[i~j] is palindrome
        boolean[][] isPa = new boolean[n][n];
        for (int i = 0; i < n; i++)
            isPa[i][i] = true;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i+len-1 < n; i++) {
                int j = i + len - 1;
                char start = s.charAt(i);
                char end = s.charAt(j);
                if (start != end)
                    continue;
                if (len <= 3 || isPa[i+1][j-1])
                    isPa[i][j] = true;
            }
        }
        // cut[j]: the min cut of palindrome partitioning required for s[0~j] 
        int[] cut = new int[n];
        for (int i = 1; i < n; i++)
            cut[i] = n;
        for (int j = 1; j < n; j++) {
            if (isPa[0][j]) {
                cut[j] = 0;
                continue;
            }
            for (int i = 0; i < j; i++) {
                if (isPa[i+1][j])
                    cut[j] = Math.min(cut[j], cut[i] + 1);
            }
        }
        return cut[n-1];
    }
    
  // dp
  public int minCut(String s) {
    int n = s.length();
    boolean[][] pali = new boolean[n][n];
    for (int r = 0; r < n; r++) {
      for (int l = 0; l < r+1; l++) {
        if (s.charAt(l) == s.charAt(r) && (r-l < 3 || pali[l+1][r-1]))
          pali[l][r] = true;
      }
    }
    int[] dp = new int[n];  // minimum cut to make palidrome at each position
    for (int i = 0; i < n; i++) dp[i] = n;
    
    for (int i = 0; i < n; i++) {
      if (pali[0][i]) {  // 0~i is a palindrome, no cut is needed
        dp[i] = 0;
        continue;
      }
      
      for (int j = 0; j < i; j++) {
        if (pali[j+1][i])  // cut between j and j+1
          dp[i] = Math.min(dp[i], dp[j]+1);
      }
    }
    
    return dp[n-1];
  }
  
  // dp2, let the middle range (l~r) be palindrome only, and expand the range gradually
  public int minCut(String s) {
    int n = s.length();
    int[] cut = new int[n];  // minimum cut to make palidrome at each position
    for (int i = 0; i < n; i++) cut[i] = n;
    
    for (int mid = 0; mid < n; mid++) {
      for (int even = 0; even <= 1; even++) {  // the len of the middle range can either be odd or even 
        for (int l = mid, r = mid+even; l >= 0 && r < n && s.charAt(l) == s.charAt(r); l--, r++) {
          cut[r] = Math.min(cut[r], l == 0 ? 0 : cut[l-1] + 1);
        }
      }
    }
    
    return cut[n-1];
  }
}

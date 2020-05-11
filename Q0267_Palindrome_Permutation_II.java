package Leetcode;

import java.util.ArrayList;

/**
 * Created by csy99 on 3/21/20.
 * <p>
 * Given a string s, return all the palindromic permutations (without duplicates) of it.
 * Return an empty list if no palindromic permutation could be form.
 * <p>
 * For example:
 * Given s = "aabb", return ["abba", "baab"].
 * Given s = "abc", return [].
 */
public class Q267_Palindrome_Permutation_II {
  public List<String> generatePalindromes(String s) {
    List<String> res = new ArrayList();
    StringBuilder sb = new StringBuilder();
    int[] freq = new int[128];
    for (char c: s.toCharArray()) freq[c]++;
    
    int oddCnt = 0;  
    for (int i = 0; i < freq.length; i++) {
      if (freq[i] % 2 == 1) {
        if (++oddCnt > 1) return res;
        sb.append((char)i);
      }
    }
    dfs(res, s.length(), freq, sb);
    return res;
  }
  
  private void dfs(List<String> res, int n, int[] freq, StringBuilder sb) {
    if (sb.length() == n) {  // no more chars can be used 
      res.add(sb.toString());
      return;
    }
    for (int i = 0; i < freq.length; i++) {
      if (freq[i] > 1) {
        freq[i] -= 2;
        sb.append((char)i);
        sb.insert(0, (char)i);
        dfs(res, n, freq, sb);
        freq[i] += 2;
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(0);
      }
    }
  }
}

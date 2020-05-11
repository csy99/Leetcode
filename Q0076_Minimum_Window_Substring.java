package Leetcode;


/**
 * Created by csy99 on 3/20/20.
 */
public class Q076_Minimum_Window_Substring {
  /**
   * key point: the starting and ending of the return value must be a char in t. 
   */
  public String minWindow(String s, String t) {
    if (s.length() == 0 || t.length() == 0) return "";
    String res = "";
    int matchCnt = 0;  // how many chars are matched in current substring compared to target t
    int[] tArr = new int[256];  // target char frequency
    for (int i = 0; i < t.length(); i++) 
      tArr[t.charAt(i)]++;
    int[] sArr = new int[256];
    int left = nextIndex(0, s, tArr);  // starting of substring
    if (left == s.length()) return "";  // no match
    int right = left;  // ending of substring
    while (right < s.length()) {
      int ending = (int)s.charAt(right);
      if (sArr[ending] < tArr[ending])
        matchCnt++;
      sArr[ending]++;
      while (left < s.length() && matchCnt == t.length()) {  // cur substring is valid
        if (res.equals("") || res.length() > right-left+1)
          res = s.substring(left, right+1);
        int starting = (int)s.charAt(left);
        if (sArr[starting] == tArr[starting])
          matchCnt--;
        sArr[starting]--;
        left = nextIndex(left+1, s, tArr);        
      }
      right = nextIndex(right+1, s, tArr);
    }
    return res;
  }
  
  /**
   * find a valid next start point in s 
   */
  private int nextIndex(int start, String s, int[] tArr) {
    int i = start;
    while (i < s.length()) {
      char c = s.charAt(i);
      if (tArr[c] > 0) return i;
      i++;
    }
    return i;
  }
}

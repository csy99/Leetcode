package Leetcode;

/**
 * Created by csy99 on 3/18/20.
 * <p>
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class Q161_One_Edit_Distance {
  public boolean isOneEditDistance(String s, String t) {
    if (s == null || t == null) return false;
    if (Math.abs(s.length() - t.length()) > 1) return false;
    if (s.length() == t.length()) return modify(s, t);
    if (s.length() > t.length()) 
      return delete(s, t);
    else
      return delete(t, s);
  }
  
  // check if t can be obtained by modifying one char in s 
  private boolean modify(String s, String t) {
    int p = 0;
    int modify = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != t.charAt(i))
        modify++;
      if (modify > 1)
        return false;
    }
    // corner case: s == t
    return modify == 1 ? true : false;
  }
  
  // check if t can be obtained by deleting one char from s
  private boolean delete(String s, String t) {
    int fast = 0;
    int slow = 0;
    while (fast < s.length() - 1) {  // no need to check the last one char
      if (s.charAt(fast) != t.charAt(slow))
        fast++;
      if (fast > slow + 1) return false;
      fast++;
      slow++;
    }
    return true;
  }
}

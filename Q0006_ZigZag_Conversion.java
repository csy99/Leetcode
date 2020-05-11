package Leetcode;

/**
 * Created by csy99 on 3/18/20.
 * <p>
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class Q0006_ZigZag_Conversion {
  public String convert(String s, int numRows) {
    if (numRows <= 1) return s;
    StringBuilder[] sb = new StringBuilder[numRows];
    for (int i = 0; i < numRows; i++) 
      sb[i] = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      int idx = i % (2*numRows-2);
      idx = idx < numRows? idx : (2*numRows-2-idx);
      sb[idx].append(s.charAt(i));
    }
    for (int i = 1; i < numRows; i++) {
      sb[0].append(sb[i]);
    }
    
    return sb[0].toString();
  }
}

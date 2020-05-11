package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/28/20.
 */
public class Q282_Expression_Add_Operators {
  List<String> res = new ArrayList();
  public List<String> addOperators(String num, int target) {
    if (num.length() == 0)
      return res;
    helper(num, "", target, 0, 0, 0);
    return res;
  }
  
  private void helper(String s, String cur, int target, int pos, long prev, long now) {
    if (s.length() == pos) {
      if (target == now)
        res.add(cur);
      return;
    } 
    for (int len = 1; len <= s.length() - pos; len++) {
      String tmp = s.substring(pos, pos+len);
      if (tmp.charAt(0) == '0' && tmp.length() > 1) break;
      long num = Long.parseLong(tmp);  
      if (num > Integer.MAX_VALUE)  // too many bits
        break;
      if (pos == 0) {  // no operator before the first expression
        helper(s, tmp, target, len, num, num);
        continue;
      }
      // add operator
      helper(s, cur + "+" + tmp, target, pos+len, num, now+num);
      // minus operator
      helper(s, cur + "-" + tmp, target, pos+len, -num, now-num);
      // multiply operator
      helper(s, cur + "*" + tmp, target, pos+len, num*prev, now-prev+prev*num);
    }
    
  }
}

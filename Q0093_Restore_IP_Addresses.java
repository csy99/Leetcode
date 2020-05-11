package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/27/20.
 */
public class Q093_Restore_IP_Addresses {
  // ip rule: four fields, with at most three digits in each field
  // each field cannot start with 0 (unless the whole field contains only one 0) or larger than 255
  List<String> res = new ArrayList();
  public List<String> restoreIpAddresses(String s) {
    if (s.length() == 0 || s.length() > 12) return res;
    helper(s, 0, "");
    return res;
  }
  
  private void helper(String remain, int field, String cur) {
    if (field == 4 && remain.length() == 0) {
      res.add(cur.substring(1));  // remove preceding "."
      return;
    } else if (field == 4 || remain.length() == 0)   // not valid combination
      return;
    // the field contains only one digit
    helper(remain.substring(1), field+1, cur + "." + remain.charAt(0));
    if (remain.length() > 1 && remain.charAt(0) != '0') {
      // the field contains two digits
      helper(remain.substring(2), field+1, cur + "." + remain.substring(0, 2));
      // the field contains two digits
      if (remain.length() > 2 && Integer.parseInt(remain.substring(0, 3)) <= 255) 
        helper(remain.substring(3), field+1, cur + "." + remain.substring(0, 3));
    }
    
  }
}

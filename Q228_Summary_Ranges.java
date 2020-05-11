package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/15/20.
 */
public class Q228_Summary_Ranges {
  public List<String> summaryRanges(int[] nums) {
    List<String> res = new ArrayList<String>();
    int i = 0;
    while (i < nums.length) {
      int idx = i;
      int pre = nums[i];
      String range;
      while (i+1 < nums.length && nums[i+1] == pre+1)
        pre = nums[++i];
      if (i - idx > 0)  // continuous range
        range = nums[idx]+"->"+nums[i];
      else 
        range = ""+nums[i];
      res.add(range);
      i++;
    }
    return res;
  }
}

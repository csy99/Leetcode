package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by csy99 on 3/18/20.
 */
public class Q0179_Largest_Number {
  public String largestNumber(int[] nums) {
    int sum = 0;  // edge case: all 0s in the array
    String[] str = new String[nums.length];
    for (int i = 0; i < nums.length; i++)  {
      str[i] = String.valueOf(nums[i]);
      sum += nums[i];
    }
    if (sum == 0) return "0";
    Arrays.sort(str, new Comparator<String>(){
      public int compare(String a, String b) {
        return (b+a).compareTo(a+b);
      }
    });
    StringBuilder sb = new StringBuilder();
    for (String s: str)
      sb.append(s);
    return sb.toString();
  }
}

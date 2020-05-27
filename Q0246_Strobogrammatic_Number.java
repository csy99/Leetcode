package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csy99 on 3/19/20.
 * <p>
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees
 * (looked at upside down).
 * <p>
 * Write a function to determine if a number is strobogrammatic.
 * The number is represented as a string.
 * <p>
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */

public class Q246_Strobogrammatic_Number {
    public boolean isStrobogrammatic(String num) {
      if (num == null || num.length() == 0) return true;
      int l = 0; 
      int r = num.length() - 1;
      while (l <= r) {
        if (num.charAt(l) == '6' && num.charAt(r) == '9' ||
          num.charAt(l) == '9' && num.charAt(r) == '6') {
          l++;
          r--;
          continue;
        } else if (num.charAt(l) == '0' && num.charAt(r) == '0' ||
          num.charAt(l) == '1' && num.charAt(r) == '1' || 
          num.charAt(l) == '8' && num.charAt(r) == '8') {
          l++;
          r--;  
          continue;
        }
        return false;
      }
      return true;
    }
    
    public boolean isStrobogrammatic(String num) {
        HashMap<Character, Character> map = new HashMap();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        if (num.length() == 0) return true;
        int l = 0;
        int r = num.length()-1;
        while (l <= r) { 
            char left = num.charAt(l);
            // if start and end digits are not in map, return false
            if (map.getOrDefault(left, '*') != num.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}

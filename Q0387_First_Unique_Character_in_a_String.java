package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csy99 on 3/17/20.
 * <p>
 * Given a string, find the first non-repeating character in it
 * and return it's index. If it doesn't exist, return -1.
 */
public class Q387_First_Unique_Character_in_a_String {
  public int firstUniqChar(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!map.containsKey(c))
        map.put(c, i);
      else
        map.put(c, -1);
    }
    int res = Integer.MAX_VALUE;
    for (char k: map.keySet()) {
      int pos = map.get(k);
      if (pos != -1 && pos < res)
        res = pos;
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }
}

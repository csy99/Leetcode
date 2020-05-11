package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by csy99 on 3/18/20.
 * <p>
 * https://leetcode.com/problems/anagrams/
 */
public class Q049_Group_Anagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    ArrayList<List<String>> res = new ArrayList<List<String>>();
    HashMap<String, List<String>> map = new HashMap<>();
    if (strs == null || strs.length == 0) return res;
    for (int i = 0; i < strs.length; i++) {
      char[] tmp = strs[i].toCharArray();
      Arrays.sort(tmp);
      String key = String.valueOf(tmp);
      List<String> val;
      if (!map.containsKey(key))
        val = new ArrayList<>();
      else 
        val = map.get(key);
      val.add(strs[i]);
      map.put(key, val);
    }
    for (String s: map.keySet()) {
      res.add(map.get(s));
    }
    return res;
  }
}

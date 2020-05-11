package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by csy99 on 3/18/20.
 * <p>
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd".
 * We can keep "shifting" which forms the sequence: "abc" -> "bcd" -> ... -> "xyz".
 * <p>
 * Given a list of strings which contains only lowercase alphabets,
 * group all strings that belong to the same shifting sequence, return:
 * <p>
 * [
 * ["abc","bcd","xyz"],
 * ["az","ba"],
 * ["acef"],
 * ["a","z"]
 * ]
 */

public class Q249_Group_Shifted_Strings {
    public List<List<String>> groupStrings(String[] strings) {
      List<List<String>> res = new ArrayList<>();
      HashMap<String, List<String>> map = new HashMap<>();
      if (strings == null || strings.length == 0)
        return res;
      for (String s: strings) {
        char[] tmp = s.toCharArray();
        if (tmp.length > 0) {
          int diff = tmp[0] - 'a';
          for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] - diff < 'a')
              tmp[i] = (char)(tmp[i]-diff+26);
            else
              tmp[i] = (char)(tmp[i]-diff);
          }
          String key = new String(tmp);
          if (map.containsKey(key))
            map.get(key).add(s);
          else {
            ArrayList<String> val = new ArrayList<>();
            val.add(s);
            map.put(key, val);
          }
        }
      }
      res.addAll(map.values());
      return res;
    }
}

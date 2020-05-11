package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q030_Substring_with_Concatenation_of_All_Words {
  // time: O(n^2), space: O(n)
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> res = new ArrayList<>();
    if (s.length() == 0 || words.length == 0) return res;
    int n = words.length;  // total number of words needed to be concat
    int m = words[0].length();   // length of each word in the array
    HashMap<String, Integer> freq = new HashMap();
    for (String str: words)
      freq.put(str, freq.getOrDefault(str, 0)+1);
    
    for (int l = 0; l < s.length()-n*m+1; l++) {
      HashMap<String, Integer> check = new HashMap(freq);
      int r = l;
      int remaining = n;
      while (remaining > 0) {
        String key = s.substring(r, r+m);
        if (check.getOrDefault(key, 0) == 0)  // unseen words appear
          break;
        check.put(key, check.get(key) - 1);
        r += m;
        remaining--;
      }
      if (remaining == 0)  // all words have been found in substring starting at i
        res.add(l);
    }
    return res;
  }
}

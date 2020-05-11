import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * For example, Given s = “eceba”,
 * T is "ece" which its length is 3.
 *
 * Created by csy99 on 3/20/20.
 */
public class Q159_Longest_Substring_with_At_Most_Two_Distinct_Characters {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    if (s == null || s.length() == 0) return 0;
    HashMap<Character, Integer> pos = new HashMap();
    int l = 0;
    int r = 0;
    int res = 0;
    while (r < s.length()) {
      pos.put(s.charAt(r), r);
      r++;
      if (pos.size() > 2) {  // delete the left most element
        int last = s.length();
        for (char c: pos.keySet())
          last = Math.min(last, pos.get(c));
        pos.remove(s.charAt(last));
        l = last + 1;
      }
      res = Math.max(res, r-l);
    }
    return res;
  }
}

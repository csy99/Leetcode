package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by csy99 on 3/18/20.
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between
 * a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 *
 * Example 2:
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 *
 * Example 3:
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 *
 * Example 4:
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 *
 * Notes:
 * You may assume pattern contains only lowercase letters,
 * and str contains lowercase letters separated by a single space.
 */
public class Q290_Word_Pattern {
  public boolean wordPattern(String pattern, String str) {
    String[] s = str.split("\\s");
    if (s.length != pattern.length())
      return false;
    String[] map = new String[26];
    for (int i = 0; i < pattern.length(); i++) {
      int idx = pattern.charAt(i) - 97;
      if (map[idx] == null)
        map[idx] = s[i];
      else {
        if (!s[i].equals(map[idx]))
          return false;
      }
    }
    HashSet<String> val = new HashSet();
    for (int i = 0; i < 26; i++) {
      if (map[i] != null) {
        if (!val.add(map[i]))
          return false;
      }
    }
    return true;
  }

    /**
     * This uses map.containsValue()
     * which has O(n) complexity
     */
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();

        String[] strArr = str.split(" ");

        if (pattern.length() != strArr.length)
            return false;

        for (int i=0; i<strArr.length; i++) {
            Character c = pattern.charAt(i);
            String word = strArr[i];

            if (map.containsKey(c)) {
                if (!map.get(c).equals(word))
                    return false;
            } else {
                if (map.containsValue(word))
                    return false;
                map.put(c, word);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q290_Word_Pattern sol = new Q290_Word_Pattern();

        String pattern = "abba";
        String str = "dog cat cat dog";

        System.out.println(sol.wordPattern(pattern, str));
    }
}

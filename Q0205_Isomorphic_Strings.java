package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by csy99 on 3/18/20.
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character
 * while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 *
 */
public class Q205_Isomorphic_Strings {
  // HashMap
  public boolean isIsomorphic(String s, String t) {
    HashMap<Character, Character> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char key = s.charAt(i);
      char val = t.charAt(i);
      if (map.containsKey(key)) { // key already exists in the map
        if (map.get(key) != val)
          return false;
      } else {  
        if (map.containsValue(val))
          return false;
        map.put(key, val);
      }
    }
    return true;
  }
    
  // ascii
  public boolean isIsomorphic(String s, String t) {
    int[] key = new int[128];
    int[] val = new int[128];
    for (int i = 0; i < s.length(); i++) {
      if (key[s.charAt(i)] != val[t.charAt(i)])
        return false;
      key[s.charAt(i)] = i+1;  // record the last seen positin, +1 means key/val exists
      val[t.charAt(i)] = i+1;
    }
    return true;
  }
  
    // ascii
    public boolean isIsomorphic(String s, String t) {
        if (s.isEmpty())  // always have same len
            return true;
        char[] key = new char[128];
        char[] val = new char[128];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            // check No two characters may map to the same character
            if (key[c1] == '\0' && val[c2] == '\0') {
                key[c1] = c2;
                val[c2] = c1;
            } else if (key[c1] == c2 && val[c2] == c1)
                continue;
            else
                return false;
        }
        return true;
    }
}

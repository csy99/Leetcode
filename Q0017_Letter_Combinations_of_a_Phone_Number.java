package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by csy99 on 3/26/20
 */
public class Q017_Letter_Combinations_of_a_Phone_Number {
  List<String> res = new ArrayList();
  public List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) return res;
    char[][] map = new char[10][4];
    map[2] = new char[]{'a','b','c'};
    map[3] = new char[]{'d','e','f'};
    map[4] = new char[]{'g','h','i'};
    map[5] = new char[]{'j','k','l'};
    map[6] = new char[]{'m','n','o'};
    map[7] = new char[]{'p','q','r','s'};
    map[8] = new char[]{'t','u','v'};
    map[9] = new char[]{'w','x','y','z'};
    StringBuilder cur = new StringBuilder();
    helper(digits, cur, 0, map);
    return res;
  }
  
  private void helper(String digits, StringBuilder cur, int idx, char[][] map) {
    if (cur.length() == digits.length()) {
      res.add(cur.toString());
      return;
    }
    for (int i = idx; i < digits.length(); i++) {
      int pos = (int) (digits.charAt(i) - '0');
      for (char c: map[pos]) {
        cur.append(c);
        helper(digits, cur, i+1, map);
        cur.deleteCharAt(cur.length()-1); 
      }
    }
  }
}

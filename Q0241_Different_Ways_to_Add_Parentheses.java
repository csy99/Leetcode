package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by csy99 on 3/20/20.
 */
public class Q241_Different_Ways_to_Add_Parentheses {
  public List<Integer> diffWaysToCompute(String input) {
    HashMap<String, List<Integer>> val = new HashMap();
    return ways(val, input);
  }
  
  private List<Integer> ways(HashMap<String, List<Integer>> val, String s) {
    if (val.containsKey(s)) return val.get(s);
    List<Integer> res = new LinkedList();

    for (int i = 0; i < s.length(); i++) {
      char op = s.charAt(i);
      if (op == '+' || op == '-' || op == '*') {  // split into two parts
        String l = s.substring(0, i);
        String r = s.substring(i+1);
        List<Integer> left = ways(val, l);
        List<Integer> right = ways(val, r);
        if (op == '+') {
          for (int j: left)
            for (int k: right)
              res.add(j+k);
        } else if (op == '-'){
          for (int j: left)
            for (int k: right)
              res.add(j-k);
        } else {
          for (int j: left)
            for (int k: right)
              res.add(j*k);
        }
      }
    }
    if (res.size() == 0) {  // single number in string
      res.add(Integer.parseInt(s));
      return res;
    }
    val.put(s, res);
    return res;
  }
}

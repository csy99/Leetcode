package Leetcode;

import java.util.HashMap;
import java.util.List;

/**
 * Created by csy99 on 3/21/20.
 */
public class Q187_Repeated_DNA_Sequences {
  public List<String> findRepeatedDnaSequences(String s) {
    List<String> repeated = new ArrayList();
    HashMap<String, Integer> seen = new HashMap();
    for (int i = 0; i < s.length() - 10 + 1; i++) {
      String seq = s.substring(i, i+10);
      seen.put(seq, seen.getOrDefault(seq, 0) + 1);
      if (seen.get(seq) == 2)
        repeated.add(seq);
    }
        
    return repeated;
  }
}

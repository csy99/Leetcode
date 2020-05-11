package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/27/20.
 * <p>
 * Write a function to generate the generalized abbreviations of a word.
 * Example:
 * Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1",
 * "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1",
 * "1o2", "2r1", "3d", "w3", "4"]
 * <p>
 * Understand the problem:
 * A classic dfs + backtracking problem. A trick here is if we've already abbrivate part of a word, we must jump at least a character.
 */

public class Q320_Generalized_Abbreviation {
  List<String> res = new ArrayList();
  public List<String> generateAbbreviations(String word) {
    if (word.length() == 0) return res;
    StringBuilder sb = new StringBuilder();
    helper(word.toCharArray(), sb, 0, 0);
    return res;
  }
  
  private void helper(char[] str, StringBuilder sb, int idx, int num) {
    int len = sb.length();
    if (idx == str.length) {
      if (num > 0)  // all words are abbreviated
        sb.append(num);
      res.add(sb.toString());
      sb.setLength(len);
      return;
    }
    // abbreviations
    helper(str, sb, idx+1, num+1);
    // not abbrev at cur idx
    if (num > 0)
      sb.append(num);
    sb.append(str[idx]);  
    helper(str, sb, idx+1, 0);
    sb.setLength(len);
  }
    
    public static void main(String[] args) {
        Q320_Generalized_Abbreviation sol = new Q320_Generalized_Abbreviation();
        String word = "word";
        List<String> res = sol.generateAbbreviations(word);
        System.out.println(res);

    }
}

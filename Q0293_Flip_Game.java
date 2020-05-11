package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/18/20.
 * <p>
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move
 * and therefore the other person will be the winner.
 * <p>
 * Write a function to compute all possible states of the string after one valid move.
 */

public class Q293_Flip_Game {
  public List<String> generatePossibleNextMoves(String s) {
    List<String> res = new ArrayList<>();
    int idx = 0;
    while (idx < s.length()) {
      int nextStart = s.indexOf("++", idx);
      if (nextStart == -1)
        return res;
      StringBuilder sb = new StringBuilder();
      sb.append(s.substring(0, nextStart));
      sb.append("--");
      sb.append(s.substring(nextStart+2));
      res.add(sb.toString());
      idx = nextStart+1;
    }
    return res;
  }
}

package Leetcode;

/**
 * Created by csy99 on 3/18/20.
 * <p>
 * You are playing the following Flip Game with your friend:
 * Given a string that contains only these two characters: + and -,
 * you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move
 * and therefore the other person will be the winner.
 * <p>
 * Write a function to determine if the starting player can guarantee a win.
 * <p>
 * For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 */
public class Q294_Flip_Game_II {
  public boolean canWin(String s) {
    for (int i = 1; i < s.length(); ++i) {
      if (s.charAt(i) == '+' && s.charAt(i - 1) == '+' && !canWin(s.substring(0, i-1) + "--" + s.substring(i+1)))
        return true;
    }
    return false;
  }

    // use HashMap to record
    public boolean canWin(String s) {
      if (s == null || s.length() < 2)
        return false;
      HashMap<String, Boolean> map = new HashMap<>();
      return checkHelper(s, map);
    }
    
    public boolean checkHelper(String s, HashMap<String, Boolean> map) {
      if (map.containsKey(s))
        return map.get(s);
      for (int i = 0; i < s.length()-1; i++) {
        if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
          String nxt = s.substring(0, i) + "--" + s.substring(i+2);
          if (!canWin(nxt)) {
            map.put(s, true);
            return true;
          }
        }
      }
      map.put(s, false);
      return false;
    }
}

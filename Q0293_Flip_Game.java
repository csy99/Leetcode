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
        StringBuilder sb = new StringBuilder(s);
        List<String> res = new ArrayList();
        int i = 0;
        while (i < s.length()-1) {
            int idx = s.indexOf("++", i);
            if (idx == -1)
                break;
            sb.setCharAt(idx, '-');
            sb.setCharAt(idx+1, '-');
            res.add(sb.toString());
            sb.setCharAt(idx, '+');
            sb.setCharAt(idx+1, '+');       
            i = idx+1;
        }
        return res;
    }
}

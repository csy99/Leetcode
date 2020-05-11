package Leetcode;

/**
 * Created by csy99 on 4/17/20.
 */
public class Q389_Find_the_Difference {
    public char findTheDifference(String s, String t) {
        char c = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}

package Leetcode;

/**
 * Created by csy99 on 3/18/20.
 * <p>
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class Q161_One_Edit_Distance {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() < t.length())  // s.length is guaranteed to be longer
         return isOneEditDistance(t, s);
        if (s.equals(t) || s.length() - t.length() > 1)
            return false;
        if (s.length() == t.length())
            return replace(s, t);
        return insert(s, t);
    }
    
    private boolean replace(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) 
                if (++diff > 1)
                    return false;
        }
        return true;
    }
    
    private boolean insert(String s, String t) {
        int j = 0;
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j == t.length() || s.charAt(i) != t.charAt(j)) {
                if (++diff > 1)
                    return false;
            } else
                j++;
        }
        return true;
    }
}

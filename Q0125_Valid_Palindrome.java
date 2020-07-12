package Leetcode;

/**
 * Created by csy99 on 3/21/20.
 */
public class Q125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while (l < r) {
            while (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
                if (l >= r) return true;
            }
            while (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
                if (l >= r) return true;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
                return false;
            l++;
            r--;
        }
        return true;
    }
}

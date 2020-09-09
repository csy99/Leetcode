/**
 * Created by csy99 on 9/8/20.
 */
class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) 
                return valid(s.substring(l, r)) | valid(s.substring(l+1, r+1));
            l++;
            r--;
        }
        return true;
    }
    
    private boolean valid(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}

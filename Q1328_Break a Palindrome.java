/**
 * Created by csy99 on 7/30/21.
 */
class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n <= 1) return "";
        char[] arr = palindrome.toCharArray();
        boolean succ = false;
        for (int i = 0; i < n/2; i++) {
            if (arr[i] != 'a') {
                succ = true;
                arr[i] = 'a';
                break;
            }
        }
        if (!succ)
            arr[n-1] = 'b';
        return new String(arr);
    }
}

/**
 * Created by csy99 on 5/19/20. 
 */
class Solution {
    public String reverseOnlyLetters(String S) {
        if (S.isEmpty()) return S;
        char[] arr = S.toCharArray();
        int l = 0;
        int r = arr.length-1;
        while (l < r) {
            while (l < r && !Character.isLetter(arr[l]))
                l++;
            while (l < r && !Character.isLetter(arr[r]))
                r--;            
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
        return new String(arr);
    }
}

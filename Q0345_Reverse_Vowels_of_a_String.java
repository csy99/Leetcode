package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by csy99 on 3/18/20.
 */
public class Q345_Reverse_Vowels_of_a_String {
    public String reverseVowels(String s) {
        if (s.isEmpty()) return s;
        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length-1;
        while (l < r) {
            while (l < r && !isVow(arr[l]))
                l++;
            while (l < r && !isVow(arr[r]))
                r--;
            if (l < r) {
                char tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;
                r--;
            }
        }
        return new String(arr);
    }
    
    private boolean isVow(char c) {
        if (c == 'a' || c == 'A' ||
           c == 'e' || c == 'E' ||
           c == 'i' || c == 'I' ||
           c == 'o' || c == 'O' ||
           c == 'u' || c == 'U')
            return true;
        return false;
    }
}

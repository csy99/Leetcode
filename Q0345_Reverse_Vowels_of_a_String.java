package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by csy99 on 3/18/20.
 */
public class Q345_Reverse_Vowels_of_a_String {
  public String reverseVowels(String s) {
    char[] str = s.toCharArray();
    int l = 0;
    int r = str.length-1;
    while (l < r) {
      while (Character.toLowerCase(str[l]) != 'a' && 
             Character.toLowerCase(str[l]) != 'e' &&
             Character.toLowerCase(str[l]) != 'i' &&
             Character.toLowerCase(str[l]) != 'o' &&
             Character.toLowerCase(str[l]) != 'u') {
        l++;
        if (l > str.length-1)
          return String.valueOf(str);
      }
      while (Character.toLowerCase(str[r]) != 'a' && 
             Character.toLowerCase(str[r]) != 'e' &&
             Character.toLowerCase(str[r]) != 'i' &&
             Character.toLowerCase(str[r]) != 'o' &&
             Character.toLowerCase(str[r]) != 'u') {
        r--;
        if (r < 0)
          return String.valueOf(str);
      }
      if (l >= r) break;
      char tmp = str[l];
      str[l++] = str[r];
      str[r--] = tmp;
    }
    return String.valueOf(str);
  }
}

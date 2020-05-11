package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by csy99 on 3/17/20.
 */
public class Q383_Ransom_Note {
  public boolean canConstruct(String ransomNote, String magazine) {
    if (ransomNote.length() > magazine.length())
      return false;
    int[] cnt = new int[26];
    for (int i = 0; i < magazine.length(); i++) {
      char c = magazine.charAt(i);
      cnt[(int)c - 97]++;
    }
    for (int i = 0; i < ransomNote.length(); i++) {
      char c = ransomNote.charAt(i);
      cnt[(int)c - 97]--;
      if (cnt[(int)c - 97] < 0)
        return false;
    }
    return true;
  }
}

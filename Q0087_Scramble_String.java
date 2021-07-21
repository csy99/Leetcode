package Leetcode;

import java.util.Arrays;

/**
 * Created by csy99 on 3/18/20.
 */
class Solution {
    Map<String, Boolean> mem = new HashMap(); 
    StringBuilder sb = new StringBuilder();
    public boolean isScramble(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m != n) return false;
        String key = getKey(s1, s2);
        if (mem.containsKey(key)) return mem.get(key);
        if (m == 1 && s1.equals(s2))
            return true;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (!String.valueOf(arr1).equals(String.valueOf(arr2))) {
            mem.put(key, false);
            return false;
        }
            
        for (int i = 0; i < n; i++) {
            String left1 = s1.substring(0, i);
            String right1 = s1.substring(i);
            String left2 = s2.substring(0, i);
            String right2 = s2.substring(i);
            if (isScramble(left1, left2) && isScramble(right1, right2)) {
                mem.put(key, true);
                return true;
            }
            if (isScramble(left1, s2.substring(n-i)) && isScramble(right1, s2.substring(0, n-i))) {
                mem.put(key, true);
                return true;
            }
        }
        mem.put(key, false);
        return false;
    }
    
    private String getKey(String s1, String s2) {
        sb.setLength(0);
        sb.append(s1);
        sb.append(s2);
        return sb.toString();
    }
}

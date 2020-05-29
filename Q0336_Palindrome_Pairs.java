package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by csy99 on 5/29/20.
 */
public class Q336_Palindrome_Pairs {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> palindromePairs(String[] words) {
        if (words.length < 2) return res;
        HashMap<String, Integer> map = new HashMap();
        boolean[] isPa = new boolean[words.length];
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
            if (isPalindrome(words[i]))
                isPa[i] = true;
        }
        // special case: "" can be combined with other palidrome
        if (map.containsKey("")) {
            int idx = map.get("");
            for (int i = 0; i < words.length; i++) {
                if (i == idx) continue;
                if (isPa[i]) {
                    addToList(i, idx);
                    addToList(idx, i);
                }
            }
        }
        // find string and reverse string
        for (int i = 0; i < words.length; i++) {
            String curRev = rev(words[i]);
            if (map.containsKey(curRev)) {
                int j = map.get(curRev);
                addToList(i, j);
            }
        }
        //case1 : s1[0:cut] is palindrome and s1[cut+1:] = reverse(s2) => (s2, s1)
        //case2 : s1[cut+1:] is palindrome and s1[0:cut] = reverse(s2) => (s1, s2)
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            for (int r = 1; r < cur.length(); r++) {
                if (isPalindrome(cur.substring(0, r))) {
                    String s2 = rev(cur.substring(r));
                    if (map.containsKey(s2)) 
                        addToList(map.get(s2), i);
                }
                if (isPalindrome(cur.substring(r))) {
                    String s2 = rev(cur.substring(0, r));
                    if (map.containsKey(s2)) 
                        addToList(i, map.get(s2));
                }
            }
        }
        return res;
    }
  
    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) 
                return false;
        }
        return true;
    }
  
    private String rev(String s) {
        return new StringBuilder(s).reverse().toString();
    }
  
    // will only add valid pair 
    private void addToList(int i, int j) {
        // cannot pair with itself
        if (i == j) return;
        List<Integer> pair = new ArrayList();
        pair.add(i);
        pair.add(j);
        res.add(pair);
    }
}
}

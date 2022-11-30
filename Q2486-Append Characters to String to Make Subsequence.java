/**
 * Created by csy99 on 11/29/22.
 */
// two pointer
// time: O(n), space: O(1)
class Solution {
    public int appendCharacters(String s, String t) {
        int m = s.length();
        int n = t.length();
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        
        int longest = 0;
        int j = 0;
        for (int i = 0; i < m; i++) {
            if (j >= n) break;
            if (arr1[i] != arr2[j]) continue;
            longest += 1;
            j += 1;
        }
        
        return n - longest;
    }
}

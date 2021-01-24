/**
 * Created by csy99 on 1/24/21.
 */
class Solution {
    public int minCharacters(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];
        for (char c: a.toCharArray())
            counts1[c - 'a']++;
        for (char c: b.toCharArray())
            counts2[c - 'a']++;
        
        int res = m+n;
        for (int i = 0; i < 26; i++) {
            res = Math.min(res, m+n-counts1[i]-counts2[i]);
            if (i > 0) {
                counts1[i] += counts1[i-1];
                counts2[i] += counts2[i-1];
            }
            if (i < 25) {
                res = Math.min(res, m-counts1[i]+counts2[i]);
                res = Math.min(res, n-counts2[i]+counts1[i]);
            }
        }
        return res;
    }
    
}

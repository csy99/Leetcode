/**
 * Created by csy99 on 10/13/21.
 */
class Solution {
    public int minSteps(String s, String t) {
        int n = s.length();
        int[] sc = new int[26];
        int[] tc = new int[26];
        for (char c: s.toCharArray())
            sc[c-'a']++;
        for (char c: t.toCharArray())
            tc[c-'a']++;
        int common = 0;
        for (int i = 0; i < 26; i++)
            common += Math.min(sc[i], tc[i]);
        return n - common;
    }
}

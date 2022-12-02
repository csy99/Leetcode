/**
 * Created by csy99 on 12/1/22.
 */
// HashMap
// time: O(n), space: O(n)
class Solution {
    public boolean closeStrings(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m != n) return false;
        
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (char c: word1.toCharArray())
            freq1[c-'a']++;
        for (char c: word2.toCharArray())
            freq2[c-'a']++;
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != 0 && freq2[i] == 0 ||
               freq1[i] == 0 && freq2[i] != 0)
                return false;
        }
        
        Map<Integer, Integer> counts = new HashMap();
        for (int f: freq1)
            if (f != 0)
                counts.put(f, counts.getOrDefault(f, 0)+1);
        for (int f: freq2) {
            if (f == 0) continue;
            if (!counts.containsKey(f))
                return false;
            int cur = counts.get(f);
            if (cur == 1) 
                counts.remove(f);
            else
                counts.put(f, cur-1);
        }
        return counts.size() == 0;
    }
}

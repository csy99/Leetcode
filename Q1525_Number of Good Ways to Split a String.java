/**
 * Created by csy99 on 10/1/21.
 */
class Solution {
    public int numSplits(String s) {
        int n = s.length();
        int[] leftUnique = new int[n];
        int[] rightUnique = new int[n];
        Map<Character, Integer> charCounts = new HashMap();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
            leftUnique[i] = charCounts.size();
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int cnt = charCounts.get(c);
            if (cnt == 1)
                charCounts.remove(c);
            else
                charCounts.put(c, cnt - 1);
            rightUnique[i] = charCounts.size();
        }
        int res = 0;
        for (int i = 0; i < n-1; i++)  // the last cut is not valid, because the right part is empty
            if (leftUnique[i] == rightUnique[i])
                res++;
        return res;
    }
}

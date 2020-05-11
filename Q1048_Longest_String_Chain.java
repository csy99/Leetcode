/**
 * Created by csy99 on 5/2/20. 
 */
class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        int[] seq = new int[words.length];
        for (int r = 1; r < words.length; r++) {
            for (int l = 0; l < r; l++) {
                if (isPre(words[l], words[r])) 
                    seq[r] = Math.max(seq[r], seq[l] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < words.length; i++) 
            res = Math.max(res, seq[i]);
        return res+1;
    }
    
    private boolean isPre(String a, String b) {
        if (b.length() - 1 != a.length())
            return false;
        int i = 0;
        int j = 0;
        while (i < a.length()) {
            if (a.charAt(i) == b.charAt(j)) 
                i++;
            j++;
            if (j - i > 1)
                return false;
        }
        return true;
    }
}

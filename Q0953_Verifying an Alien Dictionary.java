/**
 * Created by csy99 on 9/6/20.
 */
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        int[] index = new int[26];
        for (int i = 0; i < 26; i++)
            index[order.charAt(i) - 'a'] = i;
        for (int i = 0; i < n-1; i++) {
            String first = words[i];
            String second = words[i+1];
            int length = Math.min(first.length(), second.length());
            boolean succ = false;
            for (int j = 0; j < length; j++) {
                char c1 = first.charAt(j);
                char c2 = second.charAt(j);
                if (index[c1-'a'] < index[c2-'a']) {
                    succ = true;
                    break;
                } else if (index[c1-'a'] > index[c2-'a']) 
                    return false;
            }
            if (succ)
                continue;
            if (first.length() > second.length())
                return false;
        }
        return true;
    }
}

/**
 * Created by csy99 on 8/22/20.
 */
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> dict = new HashSet();
        for (String s: banned)
            dict.add(s);
        int highest = 0;
        String res = null;
        HashMap<String, Integer> cnt = new HashMap();
        // Instead, we can replace the punctuations with spaces,
        // and put all letters in lower case
        // String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        String[] arr = paragraph.split("\\s+|!|\\?|'|,|;|\\.");
        for (String word: arr) {
            word = word.toLowerCase();
            if (word.isEmpty() || dict.contains(word))
                continue;
            int freq = cnt.getOrDefault(word, 0) + 1;
            cnt.put(word, freq);
            if (freq > highest) {
                highest = freq;
                res = word;
            }
        }
        return res;
    }
}

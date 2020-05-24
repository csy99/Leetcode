/**
 * Created by csy99 on 5/23/20 during contest.
 */
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        sentence = sentence.trim();
        if (sentence.isEmpty())
            return -1;
        String[] arr = sentence.split("\\s+");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].indexOf(searchWord) == 0)
                return i+1;
        }
        return -1;
    }
}

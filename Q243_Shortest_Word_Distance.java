package Leetcode;

/**
 * Created by csy99 on 2/19/20.
 * <p>
 * Given a list of words and two words word1 and word2,
 * return the shortest distance between these two words in the list.
 * <p>
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 */

public class Q243_Shortest_Word_Distance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
          if (words[i].equals(word1)) {
            if (index2 != -1)
              minLen = Math.min(minLen, i - index2);
            index1 = i;
          }
          else if (words[i].equals(word2)) {
            if (index1 != -1)
              minLen = Math.min(minLen, i - index1);
            index2 = i;
          }
        }
        
        return minLen;
    }
}

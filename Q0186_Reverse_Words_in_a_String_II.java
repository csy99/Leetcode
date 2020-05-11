package Leetcode;

/**
 * Created by csy99 on 3/18/20.
 * <p>
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 * <p>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * <p>
 * Could you do it in-place without allocating extra space?
 */
public class Q186_Reverse_Words_in_a_String_II {
    public char[] reverseWords(char[] str) {
      reverseRange(str, 0, str.length-1);
      int start = 0;
      for (int i = 0; i < str.length; i++) {
        if (i+1 == str.length || str[i+1] == ' ')
          reverseRange(str, start, i);
        if (str[i] == ' ')
          start = i+1;
      }
      return str;
    }
    
    private void reverseRange(char[] str, int start, int end) {
      while (start < end) {
        char tmp = str[start];
        str[start++] = str[end];
        str[end--] = tmp;
      }
    }
}

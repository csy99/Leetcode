package Leetcode;

/**
 * Created by csy99 on 3/17/20.
 */
public class Q0151_Reverse_Words_in_a_String {
  // word split
  public String reverseWords(String s) {
    String[] words = s.split("\\s+");
    StringBuilder sb = new StringBuilder();
    for (int i = words.length - 1; i >= 0; i--) {
      sb.append(words[i] + " ");
    }
    return sb.toString().trim();
  }
    
  // two pointers
  public String reverseWords(String s) {
    int j = s.length();  // points to a whitespace (end of a word)
    StringBuilder sb = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == ' ') {  // must check whitespace first, since there can be multiple whitespaces between two words
        j = i;
      } else if (i == 0 || s.charAt(i-1) == ' ') {  // the start of a word
        if (sb.length() == 0)
          sb.append(s.substring(i, j));
        else
          sb.append(" " + s.substring(i, j));
      }
    }
    return sb.toString();
  }  
}

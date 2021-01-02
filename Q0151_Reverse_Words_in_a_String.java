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

// helper function
{
    public String reverseWords(String s) {
        s = s.trim();
        int n = s.length();
        char[] arr = new char[n];
        int pos = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (i > 0 && c == ' ' && s.charAt(i-1) == ' ')
                continue;
            arr[pos++] = c;
        }
        reverse(arr, 0, pos-1);
        int prev = 0;
        for (int i = 0; i < pos; i++) {
            if (arr[i] == ' ') {
                reverse(arr, prev, i-1);
                prev = i+1;
            }
        }
        reverse(arr, prev, pos-1);
        return new String(arr).trim();
    }
    
    private void reverse(char[] arr, int s, int e) {
        int l = s;
        int r = e;
        while (l < r) {
            char copy = arr[l];
            arr[l] = arr[r];
            arr[r] = copy;
            l++;
            r--;
        }
    }
}

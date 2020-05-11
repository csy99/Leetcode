package Leetcode;

/**
 * Created by csy99 on 3/19/20.
 */
public class Q316_Remove_Duplicate_Letters {
  public String removeDuplicateLetters(String s) {
    int[] cnt = new int[26];
    boolean[] inStack = new boolean[26];
    Stack<Character> st = new Stack();
    for (int i = 0; i < s.length(); i++)
      cnt[s.charAt(i) - 'a'] ++;
    
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      // char that already in the stack should not be added twice
      if (inStack[c - 'a']) {
        cnt[c - 'a']--;
        continue;
      }
        
      while (!st.isEmpty() && st.peek() > c && cnt[st.peek() - 'a'] > 0) 
        inStack[st.pop() - 'a'] = false;
      st.push(c);
      inStack[c - 'a'] = true;
      cnt[c - 'a']--;
    }
    StringBuilder sb = new StringBuilder();
    while (!st.isEmpty()) {
      sb.insert(0, st.pop());
    }
    return sb.toString();
  }
}

package Leetcode;

import java.util.Stack;

/**
 * Created by csy99 on 3/20/20.
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()"
 * Output: true
 *
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 * Input: "{[]}"
 * Output: true
 *
 */
public class Q020_Valid_Parentheses {
  public boolean isValid(String s) {
    if (s.length() % 2 != 0)  return false;
    Stack<Character> st = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '[' || c == '{')
        st.push(c);
      else {
        if (st.size() == 0) return false;
        if (c == ')' && st.pop() != '(') return false; 
        if (c == ']' && st.pop() != '[') return false;  
        if (c == '}' && st.pop() != '{') return false; 
      }
    }
    if (st.size() > 0) return false;
    return true;
  }
}

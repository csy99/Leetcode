package Leetcode;

import java.util.Stack;

/**
 * Created by csy99 on 3/24/20.
 * <p>
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class Q150_Evaluate_Reverse_Polish_Notation {
  public int evalRPN(String[] tokens) {
    Stack<Integer> st = new Stack();
    for (int i = 0; i < tokens.length; i++) {
      int res = 0;
      if (tokens[i].equals("+")) {
        res = st.pop() + st.pop();
      } else if (tokens[i].equals("-")) {
        int subtrahend = st.pop();
        int minuend  = st.pop();
        res = minuend - subtrahend;
      } else if (tokens[i].equals("*")) {
        res = st.pop() * st.pop();
      } else if (tokens[i].equals("/")) {
        int divisor = st.pop();
        int dividend = st.pop();
        res = dividend / divisor;
      } else {
        res = Integer.parseInt(tokens[i]);
      }
      st.push(res);
    }
    return st.pop();
  }
}

package Leetcode;

/**
 * Created by csy99 on 3/20/20.
 */
public class Q0032_Longest_Valid_Parentheses {

    /**
     * DP Solution
     * dp[i] means longest valid substring starting from i to the end
     * So, if s.charAt(i) == ')', dp[i] = 0 since longest valid substring cannot start from ')'
     * if s.chatAt(i) == '(', we check dp[i+1] to get the longest valid parenthesis
     * and jump to its index to check if i + dp[i+1] 's char is ')'
     * <p>
     * Also, after checking dp[j], check dp[j+1] since that can be a valid string as well
     */
  public int longestValidParentheses(String s) {
    if (s == null || s.length() < 2) return 0;
    int leftValid = -1;
    int maxLen = 0;
    Stack<Integer> st = new Stack();
    int i = 0;
    while (i < s.length()) {
      char c = s.charAt(i);
      if (c == '(')
        st.push(i);
      else {
        if (st.isEmpty())
          leftValid = i;
        else {
          st.pop();
          if (st.isEmpty())
            maxLen = Math.max(maxLen, i - leftValid);
          else
            maxLen = Math.max(maxLen, i - st.peek());
        }
      }
    i++;  
    }
    return maxLen;
  }
}

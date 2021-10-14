/**
 * Created by csy99 on 10/13/21.
 */
// stack, time: O(n), space: O(n)
class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack();
        st.push(0);
        for (char c: s.toCharArray()) {
            if (c == '(')
                st.push(0);
            else {
                int v = st.pop();
                int w = st.pop();
                st.push(w + Math.max(2*v, 1));
            }
        }
        return st.pop();
    }
}

// count, time: O(n), space: O(1)
// "( ( ) ( ( ) ) )" => "( ( ) ) + ( ( ( ) ) )"
class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        int res = 0;
        int depth = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(')
                depth++;
            else {
                depth--;
                if (s.charAt(i-1) == '(')
                    res += 1 << depth;
            }
        }
        return res;
    }
}

/**
 * Created by csy99 on 9/1/21.
 * https://www.geeksforgeeks.org/prefix-postfix-conversion/
 */
import java.util.*;
 
class Solution {
 
    public static String prefixPostfixConversion(String str) {
        int n = str.length();
        Stack<String> st = new Stack();
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (isOp(c)) {
                String first = st.pop();
                String second = st.pop();
                sb.setLength(0);
                sb.append(first).append(second).append(c);
                st.push(sb.toString());
            } else {
                st.push(c + "");
            }
        }
        return st.pop();
    }

    private static boolean isOp(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
        }
        return false;
    }
}

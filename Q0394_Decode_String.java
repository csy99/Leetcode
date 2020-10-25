package Leetcode;

import java.util.Stack;

/**
 * Created by csy99 on 3/24/20.
 */
public class Q394_Decode_String {
    public String decodeString(String s) {
        StringBuilder tail = new StringBuilder();
        Stack<String> str = new Stack();
        Stack<Integer> cnt = new Stack();
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if ('0' <= arr[i] && arr[i] <= '9') {
                int num = arr[i] - '0';
                while (i+1 < n && Character.isDigit(arr[i+1])) {
                    num = num * 10 + (arr[i+1] - '0');
                    i++;
                }
                cnt.push(num);
            } else if (arr[i] == '[') {
                str.push(tail.toString());
                tail.setLength(0);
            } else if (arr[i] == ']') {
                StringBuilder part = new StringBuilder(str.pop());
                int repeated = cnt.pop();
                for (int r = 0; r < repeated; r++)
                    part.append(tail);
                tail = part;
            } else
                tail.append(arr[i]);
        }
        return tail.toString();
    }
}

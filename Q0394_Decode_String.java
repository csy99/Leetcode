package Leetcode;

import java.util.Stack;

/**
 * Created by csy99 on 3/24/20.
 */
public class Q394_Decode_String {
  public String decodeString(String s) {
    Stack<String> str = new Stack();
    Stack<Integer> cnt = new Stack();
    StringBuilder tail = new StringBuilder();
    char[] arr = s.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      if (Character.isDigit(arr[i])) {
        int num = arr[i] - '0';
        while (i+1 < arr.length && Character.isDigit(arr[i+1])) {
          num = num*10 + (arr[i+1] - '0');
          i++;
        }
        cnt.push(num);
      } else if (arr[i] == '[') {
        str.push(tail.toString());
        tail = new StringBuilder();
      } else if (arr[i] == ']') {
        StringBuilder element = new StringBuilder(str.pop());
        int repeated = cnt.pop();
        for (int j = 0; j < repeated; j++) 
          element.append(tail);
        tail = element;
      } else
        tail.append(arr[i]);
    }
    return tail.toString();
  }
}

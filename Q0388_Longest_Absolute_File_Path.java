package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/24/20.
 */
public class Q388_Longest_Absolute_File_Path {
  public int lengthLongestPath(String input) {
    Stack<Integer> st = new Stack();
    String[] arr = input.split("\n");
    int maxLen = 0;
    st.push(0); // dummy null len
    for (int i = 0; i < arr.length; i++) {
      int numTab = arr[i].lastIndexOf("\t") + 1;
      int level = numTab + 1;
      while (level < st.size())
        st.pop();
      int curLen = st.peek() + arr[i].length() - numTab + 1;  // +1 bc add "/" btw path
      st.push(curLen);
      if (arr[i].contains("."))  // a file
        maxLen = Math.max(maxLen, curLen - 1);  // -1 bc remove "/" from end of file
    }
    return maxLen;
  }
}

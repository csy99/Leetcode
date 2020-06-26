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
  
  
class Solution {
    public int lengthLongestPath(String input) {
        if (input.isEmpty()) return 0;
        Stack<String> st = new Stack();
        String[] arr = input.split("\n");
        int longest = 0;
        if (arr[0].indexOf(".") > 0)
            longest = arr[0].length();
        StringBuilder sb = new StringBuilder(arr[0]);
        st.push(arr[0]);
        int preLevel = 0;
        for (int i = 1; i < arr.length; i++) {
            int curLevel = 0;
            int idx = 0;
            while (true) {
                int newIdx = 1+arr[i].indexOf('\t', idx);
                if (newIdx <= 0) break;
                curLevel++;
                idx = newIdx;
            }
            // System.out.println(curLevel);
            while (st.size() > 0 && curLevel - preLevel != 1) {
                String preDir = st.pop();
                sb.setLength(sb.length() - preDir.length());
                if (st.size() > 0)  // no slash before root dir
                    sb.setLength(sb.length() - 1);
                preLevel--;
            }
            String curDir = arr[i].substring(idx);
            if (st.size() > 0)
                sb.append("/");
            sb.append(curDir);
            st.push(curDir);
            if (curDir.indexOf(".") > 0 && sb.length() > longest) // must be a file
                longest = sb.length();
            preLevel = curLevel;
        }
        return longest;
    }
}
}

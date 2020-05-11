package Leetcode;

import java.util.Stack;

/**
 * Created by csy99 on 3/24/20.
 */
public class Q071_Simplify_Path {
  public String simplifyPath(String path) {
    String[] arr = path.split("/+");
    Stack<String> st = new Stack();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals(".") || arr[i].isEmpty())
        continue;
      else if (arr[i].equals("..")) {
        if (!st.isEmpty())
          st.pop();
      } else
        st.push(arr[i]);
    }
    if (st.size() == 0) return "/";
    StringBuilder sb = new StringBuilder();
    while (st.size() != 0) {
      sb.insert(0, st.pop());
      sb.insert(0, "/");
    }
    return sb.toString();
  }

    public static void main(String[] args) {
        Q071_Simplify_Path sol = new Q071_Simplify_Path();
        String path = "/a/./b/../../c/";

        String result = sol.simplifyPath(path);
        System.out.println(result);
    }
}

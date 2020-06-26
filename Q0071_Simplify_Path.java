package Leetcode;

import java.util.Stack;

/**
 * Created by csy99 on 3/24/20.
 */
public class Q071_Simplify_Path {
    public String simplifyPath(String path) {
        String[] arr = path.split("/+");
        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("..")) {
                if (st.size() > 0)
                    st.pop();
            } else if (arr[i].equals(".") || arr[i].isEmpty())
                continue;
            else
                st.push(arr[i]);
        }
        int size = st.size();
        for (int i = 0; i < size; i++) {
            sb.insert(0, st.pop());
            sb.insert(0, "/");
        }
        if (sb.length() == 0) return "/";
        return sb.toString();
    }

    public static void main(String[] args) {
        Q071_Simplify_Path sol = new Q071_Simplify_Path();
        String path = "/a/./b/../../c/";

        String result = sol.simplifyPath(path);
        System.out.println(result);
    }
}

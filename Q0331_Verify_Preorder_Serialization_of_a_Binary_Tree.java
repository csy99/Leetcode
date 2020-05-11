package Leetcode;

import java.util.Stack;

/**
 * Created by csy99 on 4/8/20.
 */
public class Q331_Verify_Preorder_Serialization_of_a_Binary_Tree {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.isEmpty()) return true;
        String[] val = preorder.split(",");
        int pointer = 1;
        int idx = 0;
        while (idx < val.length) {
            String cur = val[idx];
            pointer--;
            if (pointer < 0) return false;
            if (!cur.equals("#"))
                pointer += 2;
            idx++;
        }
        return pointer == 0;
    }

    public static void main(String[] args) {
        Q331_Verify_Preorder_Serialization_of_a_Binary_Tree sol = new Q331_Verify_Preorder_Serialization_of_a_Binary_Tree();
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(sol.isValidSerialization(preorder));
    }
}

package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by csy99 on 4/18/21.
 */
public class Q513_Find_Bottom_Left_Tree_Value {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int res = 0;
        while (q.size() > 0) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                TreeNode cur = q.poll();
                if (s == 0) 
                    res = cur.val;
                if (cur.left != null)
                    q.add(cur.left);
                if (cur.right != null)
                    q.add(cur.right);
            }
        }
        return res;
    }
}

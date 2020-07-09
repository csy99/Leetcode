package Leetcode;

import Leetcode.Util.TreeNode;
import com.whitespace.raghav.BinaryTree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 4/4/20.
 * <p>
 * Given a binary tree, collect a tree's nodes as if you were doing this:
 * Collect and remove all leaves, repeat until the tree is empty.
 */
public class Q366_Find_Leaves_of_Binary_Tree {
    List<List<Integer>> res = new ArrayList();
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        traverse(root);
        return res;
    }
    
    private int traverse(TreeNode root) {
        if (root == null) return -1;
        if (root.left == null && root.right == null) {
            addToList(0, root);
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        int level = Math.max(left, right) + 1;
        addToList(level, root);
        return level;
    }
    
    private void addToList(int level, TreeNode root) {
        while (res.size() <= level)
            res.add(new ArrayList());
        List<Integer> element = res.get(level);
        element.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);
        TreeNode j = new TreeNode(10);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        d.left = f;
        e.left = g;

        c.left = i;
        c.right = h;

        h.left = j;

        Q366_Find_Leaves_of_Binary_Tree sol = new Q366_Find_Leaves_of_Binary_Tree();
        List<List<Integer>> res = sol.findLeaves(a);
        System.out.println(res);

    }
}

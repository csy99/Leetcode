package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 4/8/20.
 */
public class Q095_Unique_Binary_Search_Trees_II {
    public List<TreeNode> generateTrees(int n) {
        return subTree(1, n);
    }
    
    private ArrayList<TreeNode> subTree(int min, int max) {
        if (min > max) return new ArrayList();
        ArrayList<TreeNode> res = new ArrayList();
        for (int rv = min; rv <= max; rv++) {
            List<TreeNode> left = subTree(min, rv-1);
            List<TreeNode> right = subTree(rv+1, max);
            if (left.size() == 0 && right.size() == 0) {
                TreeNode root = new TreeNode(rv);
                res.add(root);
            } else if (left.size() == 0) {
                for (TreeNode rightChild: right) {
                    TreeNode root = new TreeNode(rv);
                    root.right = rightChild;
                    res.add(root);
                }
            } else if (right.size() == 0) {
                for (TreeNode leftChild: left) {
                    TreeNode root = new TreeNode(rv);
                    root.left = leftChild;
                    res.add(root);
                }
            } else {
                for (TreeNode leftChild: left) 
                    for (TreeNode rightChild: right) {
                        TreeNode root = new TreeNode(rv);
                        root.left = leftChild;
                        root.right = rightChild;
                        res.add(root);
                    }
            }
        }
        
        return res;
    }
}

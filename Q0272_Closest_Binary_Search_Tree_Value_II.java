package Leetcode;

/**
 * Created by csy99 on 7/7/20.
 */

import Leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 Note:
 Given target value is a floating point.
 You may assume k is always valid, that is: k ≤ total nodes.
 You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 Follow up:
 Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

 Hint:
 Consider implement these two helper functions:
 getPredecessor(N), which returns the next smaller node to N.
 getSuccessor(N), which returns the next larger node to N.
 Try to assume that each node has a parent pointer, it makes the problem much easier.
 Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
 You would need two stacks to track the path in finding predecessor and successor node separately.
 */

public class Q272_Closest_Binary_Search_Tree_Value_II {
    // two stacks, time: O(k + log n), space: O(n)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList();
        Stack<Integer> pred = new Stack();
        Stack<Integer> succ = new Stack();
        traverseSmaller(root, target, pred);
        traverseLarger(root, target, succ);
        
        while (k > 0) {
            k--;
            if (pred.size() == 0)
                res.add(succ.pop());
            else if (succ.size() == 0)
                res.add(pred.pop());
            else if (Math.abs(pred.peek() - target) < Math.abs(succ.peek() - target))
                res.add(pred.pop());
            else
                res.add(succ.pop());
        }
        return res;
    }
  
    private void traverseSmaller(TreeNode root, double target, Stack<Integer> pred) {
        if (root == null) return;
        traverseSmaller(root.left, target, pred);
        if (root.val >= target) return;
        pred.push(root.val);
        traverseSmaller(root.right, target, pred);
    }
  
    private void traverseLarger(TreeNode root, double target, Stack<Integer> succ) {
        if (root == null) return;
        traverseLarger(root.right, target, succ);
        if (root.val < target) return;
        succ.push(root.val);
        traverseLarger(root.left, target, succ);
    }
}

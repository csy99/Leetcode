package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by csy99 on 5/18/20.
 */
public class Q501_Find_Mode_in_Binary_Search_Tree {
    // HashMap
    int mostFreq = 0;
    HashMap<Integer, Integer> freq = new HashMap();
    List<Integer> modes = new ArrayList();
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] res = new int[modes.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = modes.get(i);
        return res;
    }
    
    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        int f = 1 + freq.getOrDefault(root.val, 0);
        freq.put(root.val, f);
        if (f > mostFreq) {
            mostFreq = f;
            modes = new ArrayList();
            modes.add(root.val);
        } else if (f == mostFreq) {
            modes.add(root.val);
        }
        inorder(root.right);
    }

    // count, space: O(1)
    int mostFreq = 0;
    int cnt = 0;
    Integer prev = null;
    List<Integer> modes = new ArrayList();
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] res = new int[modes.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = modes.get(i);
        return res;
    }
    
    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev == null || prev != root.val) 
            cnt = 1;
        else
            cnt++;
        if (cnt > mostFreq) {
            mostFreq = cnt;
            modes = new ArrayList();
            modes.add(root.val);
        } else if (cnt == mostFreq) {
            modes.add(root.val);
        }
        prev = root.val;
        inorder(root.right);
    }

}

package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.HashMap;

/**
 * Created by csy99 on 5/11/20.
 */
public class Q437_Path_Sum_III {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return count(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int count(TreeNode root, int sum) {
        if (root == null)
            return 0;
        sum -= root.val;
        int cnt = 0;
        if (sum == 0)
            cnt += 1;
        int left = count(root.left, sum);
        int right = count(root.right, sum);
        return cnt + left + right;
    }
}

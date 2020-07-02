package Leetcode;

import Leetcode.Util.TreeNode;

import java.util.HashMap;

/**
 * Created by csy99 on 5/11/20.
 */
public class Q437_Path_Sum_III {
    // O(n^2)
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
    
    
    // O(n)
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }
    
    private int helper(TreeNode root, int cur, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) return 0;
        cur += root.val;
        int res = preSum.getOrDefault(cur-target, 0);
        preSum.put(cur, preSum.getOrDefault(cur,0)+1);
        res += helper(root.left, cur, target, preSum) + 
            helper(root.right, cur, target, preSum);
        preSum.put(cur, preSum.get(cur) - 1);
        return res;
    }
}

/**
 * Created by csy99 on 7/26/20.
 */
class Solution {
    int res = 0;
    
    public int countPairs(TreeNode root, int distance) {
        helper(root, distance);
        return res;
    }
    
    private int[] helper(TreeNode root, int distance) {
        if (root == null)
            return new int[11];
        int[] arr = new int[11];
        if (root.left == null && root.right == null) {
            arr[1] = 1;
            return arr;
        }
        int[] left = helper(root.left, distance);
        int[] right = helper(root.right, distance);
        for (int i = 0; i <= 10; i++)
            for (int j = 0; j <= 10; j++)
                if (i + j <= distance)
                    res += left[i]*right[j];
        for (int i = 0; i <= 9; i++)
            arr[i+1] += left[i] + right[i];
        return arr;
    }
}

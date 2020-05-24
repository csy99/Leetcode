/**
 * Created by csy99 on 5/23/20 during contest. 
 */
class Solution {
    int res = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        preOrder(root, new int[10]);
        return res;
    }
    
    private void preOrder(TreeNode root, int[] cnt) {
        if (root == null)
            return;
        int val = root.val;
        cnt[val]++;
        if (root.left == null && root.right == null) {
            if (valid(cnt))
                res++;
            cnt[val]--;
            return;
        }
        preOrder(root.left, cnt);
        preOrder(root.right, cnt);
        cnt[val]--;
    }
    
    private boolean valid(int[] cnt) {
        int odd = 0;
        for (int i = 1; i <= 9; i++) {
            if (cnt[i] % 2 == 1)
                odd++;
            if (odd >= 2)
                return false;
        }
        return true;
    }
}

/**
 * Created by csy99 on 11/20/22.
 */
// TLE, search
// time: O(q*log n), space: O(1)
class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        res = new ArrayList();
        for (int q: queries) {
            List<Integer> range = new ArrayList();
            range.add(-1);
            range.add(-1);
            res.add(range);
            traverse(root, q, true);
            traverse(root, q, false);
        }
        return res;
    }
    
    
    private void traverse(TreeNode root, int query, boolean lower_bound) {
        if (root == null) 
            return;
        
        List<Integer> range = res.get(res.size()-1);
        if (lower_bound) {
            if (root.val <= query) {
                range.set(0, root.val);
                if (root.val == query) return;
                traverse(root.right, query, lower_bound);
            } else {
                traverse(root.left, query, lower_bound);
            }
        } else {
            if (root.val >= query) {
                range.set(1, root.val);
                if (root.val == query) return;
                traverse(root.left, query, lower_bound);
            } else {
                traverse(root.right, query, lower_bound);
            }
        }
    }
}

// Treeset
// time: O(n + q*log n), space: O(n)
class Solution {
    TreeSet<Integer> values = new TreeSet();
    
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList();
        inorder(root);
        for (int q: queries) {
            List<Integer> range = new ArrayList();
            Integer lo = values.floor(q);
            range.add(lo == null ? -1 : lo);
            Integer hi = values.ceiling(q);
            range.add(hi == null ? -1 : hi);
            res.add(range);
        }
        return res;
    }
    
    
    private void inorder(TreeNode root) {
        if (root == null) 
            return;
        
        inorder(root.left);
        values.add(root.val);
        inorder(root.right);
    }
}

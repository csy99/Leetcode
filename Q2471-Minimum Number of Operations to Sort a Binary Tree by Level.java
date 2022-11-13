/**
 * Created by csy99 on 11/12/22.
 */
// HashMap
// time: O(n log n), space: O(log n)
class Solution {
    public int minimumOperations(TreeNode root) {
        int res = 0;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        Map<Integer, Integer> num_to_idx = new HashMap();
        while (!q.isEmpty()) {
            int size = q.size();
            int[] nums = new int[size];
            num_to_idx.clear();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
                nums[i] = cur.val;
                num_to_idx.put(cur.val, i);
            }
            int[] sorted = nums.clone();
            Arrays.sort(sorted);
            for (int i = 0; i < size; i++) {
                if (sorted[i] == nums[i]) continue;
                int idx = num_to_idx.get(sorted[i]);
                int copy = nums[i];
                nums[i] = nums[idx];
                nums[idx] = copy;
                num_to_idx.put(copy, idx);
                res++;
            }
        }
        return res;
    }
}

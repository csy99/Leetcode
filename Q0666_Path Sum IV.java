/**
 * Created by csy99 on 7/2/20.
 */
public class Solution {
    /**
     * @param nums: the list
     * @return: the sum of all paths from the root towards the leaves
     */
    public int pathSumIV(int[] nums) {
        if (nums.length == 0) return 0;
        Queue<Node> q = new LinkedList();
        Node root = new Node(nums[0]%10, 1, 1);
        q.add(root);
        int parent_idx = 0;
        int n_nodes = 2;
        while (q.size() > 0) {
            parent_idx++;
            Node parent = q.poll();
            while (n_nodes <= nums.length) {
                // not one of the children of parent node 
                int l = nums[n_nodes-1]/100;
                int pos = nums[n_nodes-1]/10%10;
                int pos_adjusted = pos + (1<<(l-1)) - 1;
                if (pos_adjusted > parent.pos_adjusted*2+1) {
                    // n_nodes--;
                    break;
                }
                int val = nums[n_nodes-1]%10;
                Node cur = new Node(val, l, pos_adjusted);
                q.add(cur);
                // System.out.printf("%d, %d, %d\n", parent_idx, n_nodes, val);
                if (n_nodes % 2 == 0)
                    parent.left = cur;
                else
                    parent.right = cur;
                n_nodes++;
            }
        }
        int[] res = new int[1];
        traverse(res, root, 0);
        return res[0];
    }
    
    private void traverse(int[] res, Node root, int path) {
        if (root == null) return;
        path += root.val;
        if (root.left == null && root.right == null) {
            res[0] += path;
            return;
        }
        traverse(res, root.left, path);
        traverse(res, root.right, path);
    }
}

class Node {
    int val;
    int level;
    int pos_adjusted;
    Node left;
    Node right;
    
    public Node(int v) {
        val = v;
    }
    
    public Node(int v, int l, int p) {
        val = v;
        level = l;
        pos_adjusted = p;
    }
}

/**
 * Created by csy99 on 12/28/20.
 */
class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int j = 0; j < queries.length; j++) {
            int[] qry = new int[3];
            qry[0] = queries[j][0];
            qry[1] = queries[j][1];
            qry[2] = j;
            queries[j] = qry;
        }
        Arrays.sort(queries, (a,b)->(a[1]-b[1]));
        int[] res = new int[queries.length];
        
        TrieNode root = new TrieNode();
        int i = 0;        
        for (int j = 0; j < queries.length; j++) {
            int x = queries[j][0];
            int m = queries[j][1];
            int idx = queries[j][2];
            while (i < n && nums[i] <= m)
                root.insert(root, nums[i++]);
            res[idx] = root.query(root, x); 
        }
        return res;
    }
}


class TrieNode {
    TrieNode[] children;
    
    public TrieNode() {
        children = new TrieNode[2];
    }
    
    public void insert(TrieNode root, int num) {
        TrieNode node = root;
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null)
                node.children[bit] = new TrieNode();
            node = node.children[bit];
        }
    }
    
    public int query(TrieNode root, int num) {
        TrieNode node = root;
        int sum = 0;
        for (int i = 30; i >= 0; i--) {
            if (node == null) return -1;
            int bit = (num >> i) & 1;
            if (node.children[1 - bit] != null) {
                sum |= (1 << i);
                node = node.children[1 - bit];
            } else
                node = node.children[bit];
        }
        return sum;
    }
}

package Leetcode;

/**
 * Created by csy99 on 5/12/20.
 */
public class Q508_Most_Frequent_Subtree_Sum {
    int mostFreq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> freq = new HashMap();
        ArrayList<Integer> ans = new ArrayList();
        treeSum(root, freq, ans);
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = ans.get(i);
        return res;
    }
    
    private int treeSum(TreeNode root, HashMap<Integer, Integer> freq, ArrayList<Integer> ans) {
        if (root == null)
            return 0;
        Integer sum = root.val + treeSum(root.left, freq, ans) 
            + treeSum(root.right, freq, ans);
        int f = freq.getOrDefault(sum, 0) + 1;
        freq.put(sum, f);
        if (f > mostFreq) {
            mostFreq = f;
            ans.clear();
        }
        if (f == mostFreq)
            ans.add(sum);
        return sum;
    }
}

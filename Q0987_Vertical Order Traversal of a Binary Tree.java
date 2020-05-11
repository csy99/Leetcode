/**
 * Created by csy99 on 5/11/20. 
 */
class Solution {
    TreeMap<Integer, TreeMap<Integer, List<Integer>>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList();
        map = new TreeMap();
        traverse(root, 0, 0);
        int rowIdx = 0;
        List<List<Integer>> res = new ArrayList();
        for (TreeMap<Integer, List<Integer>> cols: map.values()) {
            res.add(new ArrayList());
            for (List<Integer> rows: cols.values()) {
                Collections.sort(rows);
                res.get(rowIdx).addAll(rows);
            }
            rowIdx++;
        }
        return res;
    }
    
    private void traverse(TreeNode root, int x, int y) {
        if (root == null) return;
        if (!map.containsKey(x))
            map.put(x, new TreeMap());
        TreeMap<Integer, List<Integer>> vertical = map.get(x);
        List<Integer> element = null;
        if (vertical.containsKey(y))
            element = vertical.get(y);
        else
            element = new ArrayList();
        element.add(root.val);
        vertical.put(y, element);
        map.put(x, vertical);
        traverse(root.left, x-1, y+1);
        traverse(root.right, x+1, y+1);
    }
}

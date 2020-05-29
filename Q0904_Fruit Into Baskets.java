/**
 * Created by csy99 on 5/28/20.
 */
class Solution {
    public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> pos = new HashMap();
        int len = 1;
        int l = 0;
        int r = 0;
        while (r < tree.length) {
            if (pos.size() <= 2) {
                pos.put(tree[r], r);
                r++;
            }
            if (pos.size() > 2) {
                l = tree.length;
                for (int val: pos.values())
                    l = Math.min(l, val);
                pos.remove(tree[l]);
                l++;  // should not include the first type
            }
            len = Math.max(len, r-l);
        }
        return len;
    }
}

/**
 * Created by csy99 on 8/23/21.
 */
 class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> views = new ArrayList();
        int n = heights.length;
        int h = 0;
        for (int i = n-1; i >= 0; i--) {
            if (heights[i] > h) {
                h = heights[i];
                views.add(i);
            }
        }
        int m = views.size();
        int[] res = new int[m];
        for (int i = 0; i < m; i++)
            res[i] = views.get(m-i-1);
        return res;
    }
}

/**
 * Created by csy99 on 7/28/21.
 */
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int d = m-1; d >= -(n-1); d--) {
            int start = Math.max(0, d);
            List<Integer> list = new ArrayList();
            for (int i = start; i < m && i-d < n && i-d >= 0; i++) {
                int j = i-d;
                list.add(mat[i][j]);
            }
            Collections.sort(list);
            for (int i = start; i < m && i-d < n && i-d >= 0; i++) {
                int j = i-d;
                mat[i][j] = list.remove(0);
            }
        }
        return mat;
    }
}

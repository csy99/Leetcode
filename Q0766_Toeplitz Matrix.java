/**
 * Created by csy99 on 1/15/21.
 */
class Solution {
    // HashMap, time: O(mn), space: O(m+n)
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i-j;
                if (!map.containsKey(key))
                    map.put(key, matrix[i][j]);
                else if (matrix[i][j] != map.get(key))
                    return false;
            }
        }
        return true;
    }
    
    // Comparison, time: O(mn), space: O(1)
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0 && matrix[i][j] != matrix[i-1][j-1])
                    return false;
            }
        }
        return true;
    }
}

/**
 * Created by csy99 on 8/9/20.
 */
class Solution {
    public int minSwaps(int[][] grid) {
        int[] zeros = gridToVec(grid);
        return minSwaps(zeros);
    }
    
    private int minSwaps(int[] zeros) {
        int n = zeros.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (zeros[i] >= n-i-1) continue;
            int j = i + 1;
            while (j < n && zeros[j] < n-i-1)
                j++;
            if (j >= n)
                return -1;
            while (i < j) {
                // swap two rows
                int tmp = zeros[j];
                zeros[j] = zeros[j-1];
                zeros[j-1] = tmp;
                res++;
                j--;
            }
        }
        return res;
    }
    
    private int zerosAtEnd(int[] a) {
        int cnt = 0;
        int n = a.length;
        for (int i = n-1; i >= 0; i--) {
            if (a[i] == 0)
                cnt++;
            else
                break;
        }
        return cnt;
    }
    
    private int[] gridToVec(int[][] grid) {
        int[] zeros = new int[grid.length];
        int i = 0;
        for (int[] row: grid)
            zeros[i++] = zerosAtEnd(row);
        return zeros;
    }
}

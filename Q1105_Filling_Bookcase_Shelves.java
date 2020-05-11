/**
 * Created by csy99 on 5/2/20.
 */
class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int n = books.length;
        if (n == 0) return 0;
        int[] optHeight = new int[n];
        for (int i = 0; i < n; i++)
            optHeight[i] = Integer.MAX_VALUE / 2;
        for (int r = 0; r < n; r++) {  // current book that we try to place in the shelf
            int h = 0; 
            int w = 0;
            for (int l = r; l >= 0; l--) {  // the start of the last level
                w += books[l][0];
                if (w > shelf_width) break;
                h = Math.max(h, books[l][1]);
                int prevLevels = l == 0 ? 0 : optHeight[l - 1];
                optHeight[r] = Math.min(optHeight[r], prevLevels + h);
            }
        }
        return optHeight[n-1];
    }
}

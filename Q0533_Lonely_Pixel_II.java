package Leetcode;

/**
 * Created by csy99 on 4/17/21.
 */
public class Solution {
    public int findBlackPixel(char[][] picture, int N) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap();
        int m = picture.length;
        int n = picture[0].length;
        int rows = 0;
        int cols = 0;
        int[] col_cnt = new int[n];  
        for (int i = 0; i < m; i++) {
            sb.setLength(0);
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                sb.append(picture[i][j]);
                if (picture[i][j] == 'B') {
                    cnt++;
                    col_cnt[j]++;
                }
            }
            if (cnt == N) {
                String key = sb.toString();
                map.put(key, map.getOrDefault(key,0)+1);  
            }   
        }
        for (int val: map.values())
            rows = Math.max(rows, val);
        for (int j = 0; j < n; j++)
            if (col_cnt[j] == N)
                cols++;
        return rows * cols;
    }
}

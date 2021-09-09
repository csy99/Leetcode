/**
 * Created by csy99 on 9/8/21.
 */
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;
        char[][] graph = new char[m][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                graph[j][n-i-1] = box[i][j];
        for (int i = m-2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == '#') {
                    int k = i;
                    while (k+1 < m && graph[k+1][j] == '.') 
                        k++;
                    if (k == i) continue; 
                    graph[k][j] = '#';
                    graph[i][j] = '.';
                }
            }
        }
        return graph;
    }
}

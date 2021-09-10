/**
 * Created by csy99 on 9/8/21.
 */
class Solution {
    // simulation, time: O(m^2n), space: O(mn)
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
    
    // two pointer, time: O(mn), sapce: O(mn)
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        for (int i = 0; i < m; i++) {
            int bot = n-1;
            for (int j = n-1; j >= 0; j--) {
                if (box[i][j] == '*')
                    bot = j-1;
                if (box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][bot] = '#';
                    bot--;
                }
            }
        }
        char[][] graph = new char[n][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                graph[j][m-i-1] = box[i][j];
        return graph;
    }
}

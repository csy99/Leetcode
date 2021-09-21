package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 9/20/21.
 * <p>
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges
 * (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.
 * <p>
 * Example 1:
 * 0 3
 * | |
 * 1 --- 2 4
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 */
public class Q323_Number_of_Connected_Components_in_an_Undirected_Graph {
    // bfs, time: O(n), space: O(n)
    public int countComponents(int n, int[][] edges) {
        boolean[][] graph = new boolean[n][n];
        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];
            graph[a][b] = true;
            graph[b][a] = true;
        }
        int[] roots = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++)
            roots[i] = i;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            Queue<Integer> q = new LinkedList();
            q.add(i);
            while (q.size() > 0) {
                int cur = q.poll();
                roots[cur] = i;
                visited[cur] = true;
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && graph[cur][j])
                        q.add(j);
                }
            }
        }
        Set<Integer> parts = new HashSet();
        for (int i = 0; i < n; i++)
            parts.add(roots[i]);
        return parts.size();
    }
}

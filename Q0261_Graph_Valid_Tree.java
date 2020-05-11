package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by csy99 on 4/12/20.
 * <p>
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges
 * (each edge is a pair of nodes), check if these edges form a valid tree.
 * <p>
 * Analysis
 * <p>
 * This problem can be converted to finding a cycle in a graph.
 * It can be solved by using DFS (Recursion) or BFS (Queue).
 */
public class Q261_Graph_Valid_Tree {

    // DFS
    public boolean validTreeDFS(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            map.put(i, list);
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        if (!helper(0, -1, map, visited))
            return false;

        for (boolean b : visited) {
            if (!b)
                return false;
        }

        return true;
    }

    public boolean helper(int curr, int parent, Map<Integer, List<Integer>> map, boolean[] visited) {
        if (visited[curr])
            return false;

        visited[curr] = true;

        for (int i : map.get(curr)) {
            if (i != parent && !helper(i, curr, map, visited)) {
                return false;
            }
        }

        return true;
    }

    // BFS
    public boolean validTreeBFS(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            map.put(i, list);
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int top = queue.poll();
            if (visited[top])
                return false;

            visited[top] = true;

            for (int i : map.get(top)) {
                if (!visited[i])
                    queue.offer(i);
            }
        }

        for (boolean b : visited) {
            if (!b)
                return false;
        }

        return true;
    }
    
  // Union Find  
  public boolean validTree(int n, int[][] edges) {
    if (n != edges.length + 1)
      return false;
    UFS ufs = new UFS(n-1);
    for (int i = 0; i < edges.length; i++) {
      if (!ufs.union(edges[i][0], edges[i][1]))
        return false;
    }
    return true;
  }
  
  class UFS {
    int[] parents;
    int[] ranks;
    
    public UFS(int n) {
      parents = new int[n+1];
      ranks = new int[n+1];
      for (int i = 0; i < n+1; i++) {
        parents[i] = i;
        ranks[i] = 1;
      }
    }
    
    public int find(int u) {
      while (u != parents[u]) {
        parents[u] = parents[parents[u]];
        u = parents[u];
      }
      return u;
    }
    
    public boolean union(int u, int v) {
      int ru = find(u);
      int rv = find(v);
      if (ru == rv) return false;
      if (parents[ru] < parents[rv])
        parents[ru] = rv;
      else if (parents[rv] < parents[ru])
        parents[rv] = ru;
      else {
        parents[rv] = ru;
        ranks[ru]++;
      }
      return true;
    }
  }
}

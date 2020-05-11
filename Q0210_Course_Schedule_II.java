package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by csy99 on 4/10/20.
 */
public class Q210_Course_Schedule_II {
    int[] seq;
    int idx;
    ArrayList<ArrayList<Integer>> graph = new ArrayList();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        seq = new int[numCourses];
        idx = 0;
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList());
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            graph.get(course).add(prereq);
        }
        // 1: visiting, 2: visited
        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, state))
                return new int[0];
        }
        return seq;
    }
    
    // return true if cycle exists
    private boolean dfs(int num, int[] state) {
        if (state[num] == 1) return true;
        if (state[num] == 2) return false;
        state[num] = 1;
        for (int preq: graph.get(num)) {
            if (dfs(preq, state))
                return true;
        }
        state[num] = 2;
        seq[idx++] = num;
        return false;
    }
}

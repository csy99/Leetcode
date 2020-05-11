package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by csy99 on 4/10/20.
 */
public class Q207_Course_Schedule {
    ArrayList<ArrayList<Integer>> graph = new ArrayList();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList());
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prereq = prerequisites[i][1];
            graph.get(course).add(prereq);
        }
        // 0: unvisited, 1: visiting, 2: visited
        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, state))
                return false;
        }
        return true;
    }
    
    /**
     * return true if there is a cycle in the graph
     */
    public boolean dfs(int num, int[] state) {
        if (state[num] == 1) 
            return true;
        if (state[num] == 2)
            return false;
        state[num] = 1;
        for (int pre: graph.get(num)) {
            if (dfs(pre, state))
                return true;            
        }
        state[num] = 2;
        return false;
    }
}

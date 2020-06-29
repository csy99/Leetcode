package Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by csy99 on 6/29/20.
 */
public class Q332_Reconstruct_Itinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        // build adj mat
        Map<String, List<String>> routes = new HashMap();
        for (List<String> ticket: tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            List<String> canReach = routes.get(src);
            if (canReach == null)
                canReach = new ArrayList();
            canReach.add(dst);
            routes.put(src, canReach);
        }
        // sort the dst for each src so that we prefer the smaller lexi order
        for (Map.Entry<String, List<String>> entry: routes.entrySet())
            Collections.sort(entry.getValue());    
        // do DFS
        List<String> path = new ArrayList();
        path.add("JFK");
        int[] cnt = new int[] {tickets.size()};
        if (dfs(routes, "JFK", path, cnt))
            return path;
        return new ArrayList();
    }
    
    private boolean dfs(Map<String, List<String>> routes, String src, List<String> path, int[] cnt) {
        if (cnt[0] == 0)  // use all tickets
            return true;
        List<String> canReach = routes.get(src);
        if (canReach == null || canReach.size() == 0)
            return false;
        int size = canReach.size();
        for (int i = 0; i < size; i++) {
            String cur = canReach.get(i);
            path.add(cur);
            cnt[0]--;
            canReach.remove(i);  // preventing from being used twice
            if (dfs(routes, cur, path, cnt))
                return true;
            path.remove(path.size()-1);
            cnt[0]++;
            canReach.add(i, cur);
        }
        return false;
    }
}

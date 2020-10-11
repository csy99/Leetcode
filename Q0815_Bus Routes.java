/**
 * Created by csy99 on 10/10/20.
 */
class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        int n = routes.length;
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < n; i++) {
            for (int stop: routes[i]) {
                List<Integer> busHere = map.getOrDefault(stop, new ArrayList());
                busHere.add(i);
                map.put(stop, busHere);
            }
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList();
        q.add(S);
        int res = 0;
        while (q.size() > 0) {
            res++;
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int curStop = q.poll();
                List<Integer> busHere = map.get(curStop);
                for (int bus: busHere) {
                    if (visited[bus])
                        continue;
                    visited[bus] = true;
                    for (int nxtStop: routes[bus]) {
                        if (nxtStop == T)
                            return res;
                        q.add(nxtStop);
                    }
                }
            }
        }
        return -1;
    }
}

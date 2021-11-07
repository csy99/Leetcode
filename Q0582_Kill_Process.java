/**
 * Created by csy99 on 11/7/21.
 */
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> graph = new HashMap();
        int n = pid.size();
        for (int i = 0; i < n; i++) {
            int child = pid.get(i);
            graph.putIfAbsent(child, new ArrayList());
            int par = ppid.get(i);
            graph.putIfAbsent(par, new ArrayList());
            List<Integer> children = graph.get(par);
            children.add(child);
            graph.put(par, children);
        } 
        List<Integer> res = new ArrayList();
        addToList(graph, res, kill);
        return res;
    }

    private void addToList(Map<Integer, List<Integer>> graph, List<Integer> res, int pid) {
        res.add(pid);
        List<Integer> children = graph.get(pid);
        for (int child: children)
            addToList(graph, res, child);
    }
}

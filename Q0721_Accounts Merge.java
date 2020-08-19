/**
 * Created by csy99 on 8/19/20.
 */
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap();
        Map<String, List<String>> graph = new HashMap();
        // construct the graph
        for (List<String> account: accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!graph.containsKey(email)) {
                    List<String> neighbors = new ArrayList();
                    graph.put(email, neighbors);
                }
                graph.get(email).add(account.get(1));
                graph.get(account.get(1)).add(email);
                emailToName.put(email, name);
            }
        }
        // construct final result using DFS
        List<List<String>> res = new ArrayList();
        Set<String> seen = new HashSet();
        for (String email: graph.keySet()) {
            if (seen.contains(email)) 
                continue;
            seen.add(email);
            Stack<String> st = new Stack();
            st.push(email);
            List<String> component = new ArrayList();
            while (st.size() > 0) {
                String cur = st.pop();
                component.add(cur);
                for (String nei: graph.get(cur)) {
                    if (seen.contains(nei))
                        continue;
                    seen.add(nei);
                    st.push(nei);
                }
            }
            Collections.sort(component);
            component.add(0, emailToName.get(email));
            res.add(component);
        }
        return res;
    }
}

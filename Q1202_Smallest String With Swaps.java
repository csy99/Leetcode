/**
 * Created by csy99 on 7/13/21.
 */
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        char[] arr = s.toCharArray();
        UFS ufs = new UFS(n, arr);
        for (List<Integer> pair: pairs) {
            int u = pair.get(0);
            int v = pair.get(1);
            ufs.union(u, v);
        }
        List<Character>[] chars = new List[n];
        for (int i = 0; i < n; i++) {
            int root = ufs.find(i);
            if (chars[root] == null)
                chars[root] = new LinkedList<Character>();
            chars[root].add(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        HashSet<Integer> seen = new HashSet();
        for (int i = 0; i < n; i++) {
            int root = ufs.find(i);
            List<Character> ch = chars[root];
            if (!seen.contains(root)) {
                Collections.sort(ch);
                seen.add(root);
            }
            sb.append(ch.get(0));
            ch.remove(0);
            chars[root] = ch;
        }
        return sb.toString();
    }
}

class UFS {
    
    int[] parents;
    
    public UFS(int n, char[] arr) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }
    
    boolean union(int u, int v) {
        int ru = find(u);
        int rv = find(v);
        if (ru == rv) return false;
        parents[ru] = rv;
        return true;
    }
    
    int find(int u) {
        while (parents[u] != u) {
            parents[u] = parents[parents[u]];
            u = parents[u];
        }
        return u;
    }
}

/**
 * Created by csy99 on 1/30/2021 during contest. 
 */
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap();
        Set<Integer> start = new HashSet();
        for (int[] pair: adjacentPairs) {
            int a = pair[0];
            int b = pair[1];
            List<Integer> neighbors = map.getOrDefault(a, new ArrayList());
            neighbors.add(b);
            if (neighbors.size() == 1)
                start.add(a);
            else
                start.remove(a);
            map.put(a, neighbors);
            neighbors = map.getOrDefault(b, new ArrayList());
            neighbors.add(a);
            if (neighbors.size() == 1)
                start.add(b);
            else
                start.remove(b);
            map.put(b, neighbors);
        }
        int n = map.size();
        int[] res = new int[n];
        int idx = 0;
        int s = 0;
        for (int num: start)
            s = num;
        res[idx++] = s;
        start = new HashSet();
        start.add(s);
        while (idx < n) {
            List<Integer> neighbors = map.get(res[idx-1]);
            int num = 0;
            if (!start.contains(neighbors.get(0)))
                num = neighbors.get(0);
            else
                num = neighbors.get(1);
            res[idx++] = num;
            start.add(num);
        }
        return res;
    }
}

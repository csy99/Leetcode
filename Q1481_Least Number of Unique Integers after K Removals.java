/**
 * Created by csy99 on 7/29/21.
 */
// sort, time: O(n log n), space: O(n)
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        if (k >= n) return 0;
        Map<Integer, Integer> counts = new HashMap();
        for (int num: arr)
            counts.put(num, counts.getOrDefault(num,0)+1);
        List<Integer> q = new ArrayList();
        for (int key: counts.keySet()) 
            q.add(key);
        Collections.sort(q, (a,b)->(counts.get(a)-counts.get(b)));
        while (k > 0) {
            Integer key = q.remove(0);
            int cnt = counts.get(key);
            k -= cnt;
        }
        int res = q.size();
        if (k < 0) res++;
        return res;
    }
}

class Solution {
    // bucket sort, time: O(n), space: O(n)
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        int n = arr.length;
        if (k >= n) return 0;
        Map<Integer, Integer> counts = new HashMap();
        for (int num: arr)
            counts.put(num, counts.getOrDefault(num,0)+1);
        int res = counts.size();
        int[] freqs = new int[n+1];
        for (int f: counts.values()) 
            freqs[f]++;
        for (int f = 1; f <= n; f++) {
            if (freqs[f] == 0) continue;
            while (freqs[f] > 0 && k >= f) {
                k -= f;
                freqs[f]--;
                res--;
            }
            if (freqs[f] > 0) break;
        }
        return res;
    }
}

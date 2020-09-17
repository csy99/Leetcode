/**
 * Created by csy99 on 9/17/20.
 */
class Solution {
    // HashMap, time: O(n^3 log n), space: O(n)
    public int longestArithSeqLength(int[] A) {
        int n = A.length;
        HashMap<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < n; i++) {
            List<Integer> positions = map.getOrDefault(A[i], new ArrayList());
            positions.add(i);
            map.put(A[i], positions);
        }
            
        int longest = 2;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                int len = 2;
                int d = A[j] - A[i];
                int target = A[j] + d;
                while (map.containsKey(target)) {
                    List<Integer> positions = map.get(target);
                    int pos = j;  // should be binary search
                    int l = 0;
                    int r = positions.size()-1;
                    while (l < r) {
                        int mid = (r - l) / 2 + l;
                        if (positions.get(mid) <= j)
                            l = mid + 1;
                        else
                            r = mid;
                    }
                    if (l >= positions.size() || positions.get(l) <= j)
                        break;
                    len++;
                    target += d;
                }
                longest = Math.max(longest, len);
            }
            if (i+longest >= n) break;
        }
        return longest;
    }
}

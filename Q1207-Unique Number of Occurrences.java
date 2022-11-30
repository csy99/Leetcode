/**
 * Created by csy99 on 11/29/22.
 */
// hashmap and hashset
// time: O(n), space: O(n)
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] counts = new int[2001];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            counts[arr[i]+1000] += 1;
        }
        Set<Integer> seen = new HashSet();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                if (seen.contains(counts[i]))
                    return false;
                else
                    seen.add(counts[i]);
            }
        }
        return true;
    }
}

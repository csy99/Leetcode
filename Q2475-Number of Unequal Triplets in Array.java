/**
 * Created by csy99 on 11/20/22.
 */
// HashMap
// time: O(l^3), space: O(l)
class Solution {
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> counts = new HashMap();
        for (int num: nums)
            counts.put(num, counts.getOrDefault(num, 0)+1);
        int[] arr = new int[counts.size()];
        int pos = 0;
        for (int cnt: counts.values())
            arr[pos++] = cnt;
        
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n-2; i++)
            for (int j = i+1; j < n-1; j++)
                for (int k = j+1; k < n; k++)
                    res += arr[i]*arr[j]*arr[k];
        return res;
    }
}

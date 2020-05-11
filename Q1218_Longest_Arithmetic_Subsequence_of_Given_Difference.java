/**
 * Created by csy99 on 4/27/20.
 */
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        // use value as key, not the index in input array
        HashMap<Integer, Integer> cnt = new HashMap();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int seq = cnt.getOrDefault(arr[i]-difference, 0);
            cnt.put(arr[i], seq+1);
            if (seq+1 > max)
                max = seq+1;
        }
        return max;
    }
}

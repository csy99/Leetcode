/**
 * Created by csy99 on 9/22/21.
 */
class Solution {
    public int[] frequencySort(int[] nums) {
        final int N = 100;
        int[] counts = new int[2*N+1];
        Map<Integer, List<Integer>> freq2num = new HashMap();
        int n = nums.length;
        for (int num: nums) 
            counts[num+N]++;
        int lo_f = n;
        int hi_f = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) continue;
            lo_f = Math.min(counts[i], lo_f);
            hi_f = Math.max(counts[i], hi_f);
            List<Integer> candidates = freq2num.getOrDefault(counts[i], new ArrayList());
            candidates.add(i-N);
            freq2num.put(counts[i], candidates);
        }
        int[] res = new int[n];
        int i = 0;
        for (int f = lo_f; f <= hi_f; f++) {
            List<Integer> candidates = freq2num.getOrDefault(f, new ArrayList());
            Collections.sort(candidates, Collections.reverseOrder());
            for (int candidate: candidates) {
                for (int c = 0; c < f; c++)
                    res[i++] = candidate;
            }
        }
        return res;
    }
}

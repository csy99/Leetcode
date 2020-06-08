/**
 * Created by csy99 on 3/9/20.
 */
public class Q164_Maximum_Gap {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        double gap = (max-min)/(double)n;
        Integer[][] buckets = new Integer[n][2];
        for (int num: nums) {
            int idx = (int)((num-min)/gap);
            if (num == max) idx = n-1;
            Integer[] range = buckets[idx];
            if (range[0] == null) {
                range[0] = num;
                range[1] = num;
            } else {
                range[0] = Math.min(range[0], num);
                range[1] = Math.max(range[1], num);
            }
        }
        int res = 0;
        int prevLargest = -1;
        int i = 0;
        while (buckets[i][0] == null)
            i++;
        prevLargest = buckets[i][1];
        for (i = i+1; i < n; i++) {
            if (buckets[i][0] == null) continue;
            res = Math.max(res, buckets[i][0] - prevLargest);
            prevLargest = buckets[i][1];
        }
        return res;
    }
}

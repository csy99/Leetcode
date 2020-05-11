/**
 * Created by csy99 on 3/9/20.
 */
public class Q164_Maximum_Gap {
    private class Pair {
        private int min, max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2)
            return 0;

        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        double gap = ((double) max - min) / nums.length;
        Pair[] bucket = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) { // put all elements into different bucket
            int idx = (int) Math.ceil((nums[i] - min) / gap) - 1;
            idx = Math.max(0, idx); // the min value should be put into the first bucket
            Pair p = bucket[idx];
            if (p == null) {
                bucket[idx] = new Pair(nums[i], nums[i]);
            } else {
                p.min = Math.min(p.min, nums[i]);
                p.max = Math.max(p.max, nums[i]);
            }
        }

        int res = 0;
        int prevMax = bucket[0].max;
        for (int pos = 1; pos < nums.length; pos++) {
            if (bucket[pos] == null)
                continue;
            res = Math.max(res, bucket[pos].min - prevMax);
            prevMax = bucket[pos].max;
        }
        return res;
    }
}

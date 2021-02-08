/**
 * Created by csy99 on 2/7/2021.
 */
class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        List<Integer> first = new ArrayList();
        List<Integer> second = new ArrayList();
        helper(nums, 0, n/2, 0, first);
        helper(nums, n/2, n, 0, second);
        Collections.sort(first);
        int res = Math.abs(goal);
        for (int secSum: second) {
            int left = goal - secSum;
            if (first.get(0) > left) { // all subset sums from first half are too big => Choose the smallest
                res = Math.min(res, Math.abs(first.get(0)+secSum-goal));
                continue;
            }
            if (first.get(first.size()-1) < left) {  // all subset sums are too small
                res = Math.min(res, Math.abs(first.get(first.size()-1)+secSum-goal));
                continue;
            }
            int pos = Collections.binarySearch(first, left);
            if (pos >= 0)  // exact match found
                return 0;
            pos = -1 * (pos+1);
            int low = pos-1;
            res = Math.min(res, Math.abs(first.get(low)+secSum-goal));
            res = Math.min(res, Math.abs(first.get(pos)+secSum-goal));
        }
        return (int)res;
    }
    
    private long[] findCloser(long goal, long a, long b) {
        long tmp1 = Math.abs(goal-a);
        long tmp2 = Math.abs(goal-b);
        long[] arr = new long[2];
        if (tmp1 <= tmp2) {
            arr[0] = tmp1;
            arr[1] = a;
        } else {
            arr[0] = tmp2;
            arr[1] = b;
        }
        return arr;
    }
    
    private void helper(int[] nums, int idx, int end, int sum, List<Integer> cur) {
        if (idx == end) {
            cur.add(sum);
            return;
        }
        helper(nums, idx+1, end, sum, cur);
        helper(nums, idx+1, end, sum+nums[idx], cur);
    }
}

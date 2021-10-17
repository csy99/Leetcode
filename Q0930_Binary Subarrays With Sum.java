/**
 * Created by csy99 on 5/29/20.
 */
// hashmap, time: O(n), space: O(k)
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int n = A.length;
        if (n == 0)
            return 0;
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++)
            sum[i+1] = sum[i] + A[i];
        int res = 0;
        HashMap<Integer, Integer> count = new HashMap();
        // looking for number i < j w/ sum[j]-sum[i] == S
        for (int i: sum) {
            res += count.getOrDefault(i, 0);
            count.put(i+S, count.getOrDefault(i+S, 0)+1);
        }
        return res;
    }
}

// two pointer, time: O(n), space: O(1)
class Solution {
    int n = 0;
    public int numSubarraysWithSum(int[] nums, int goal) {
        n = nums.length;
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    private int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;
        int res = 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            goal -= nums[j];
            while (goal < 0)
                goal += nums[i++];
            res += j - i + 1;
        }
        return res;
    }
}

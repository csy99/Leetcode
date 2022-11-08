/**
 * Created by csy99 on 11/7/22.
 */

// HashMap
// time: O(n), space: O(k)
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0;
        long sum = 0;
        int i = 0;
        Map<Integer, Integer> counts = new HashMap();
        for (; i < k; i++) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0)+1);
            sum += nums[i];
        }
        while (i < n) {
            if (counts.size() == k)
                maxSum = Math.max(sum, maxSum);
            
            sum -= nums[i-k];
            int cnt = counts.get(nums[i-k]);
            if (cnt == 1) 
                counts.remove(nums[i-k]);
            else 
                counts.put(nums[i-k], cnt-1);
            
            if (i >= n) break;
            
            sum += nums[i];
            counts.put(nums[i], counts.getOrDefault(nums[i], 0)+1);
            i++;
        }
        if (counts.size() == k)
            maxSum = Math.max(sum, maxSum);
        return maxSum;
    }
}

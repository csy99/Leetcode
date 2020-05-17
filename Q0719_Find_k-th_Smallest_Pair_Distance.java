/**
 * Created by csy99 on 4/25/20.
 */
class Solution {
    // binary search: value
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = nums[n - 1];
        while (l < r) {
            int mid = (l + r) / 2;
            int cnt = 0; 
            int j = 1;
            for (int i = 0; i < n - 1; i++) {
                while (j < n && nums[j] - nums[i] <= mid)
                    j++;
                cnt += j - i - 1;
            }
            if (cnt >= k)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
    
    // bucket sort
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[n-1];
        int[] dist = new int[max+1];
        for (int i = 0; i < n; i++) 
            for (int j = i+1; j < n; j++) 
                dist[nums[j] - nums[i]]++;
        int cnt = 0;
        for (int i = 0; i < max+1; i++) {
            cnt += dist[i];
            if (cnt >= k)
                return i;
        }
        return -1;
    }
}

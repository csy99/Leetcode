/**
 * Created by csy99 on 11/18/22.
 */
// time: O(n), space: O(k)
class Solution {
    public int distinctAverages(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<Integer> seen = new HashSet();
        for (int i = 0; i < n/2; i++)
            seen.add(nums[i] + nums[n-i-1]);
        return seen.size();
    }
}

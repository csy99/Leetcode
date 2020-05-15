/**
 * Created by csy99 on 5/15/20.
 */
class Solution {
    int[] arr;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum % k != 0) return false;
        // only work for Integer, not int
        // Arrays.sort(nums, new Comparator<Integer> () {
        //     public int compare(int a, int b) {
        //         return b-a;
        //     }
        // });
        arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) 
            arr[i] = nums[nums.length-1-i];
        return dfs(sum/k, 0, k, 0);
    }
    
    private boolean dfs(int target, int cur, int k, int used) {
        if (k == 0)
            return used == (1 << arr.length) - 1;
        for (int i = 0; i < arr.length; i++) {
            if ((used & (1 << i)) > 0)
                continue;
            int t = cur + arr[i];
            if (t > target) break;
            int updatedUsed = used | (1 << i);
            if (t == target && dfs(target, 0, k-1, updatedUsed))
                return true;
            if (dfs(target, t, k, updatedUsed))
                return true;
        }
        return false;
    }
}

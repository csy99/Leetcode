package Leetcode;

/**
 * Created by csy99 on 8/31/20.
 */
public class Q442_Find_All_Duplicates_in_an_Array {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i])-1;
            if (nums[idx] < 0)
                res.add(idx+1);
            nums[idx] = -nums[idx];
        }
        return res;
    }
}

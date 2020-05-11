/**
 * Created by csy99 on 5/2/20. 
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int[] cnt = new int[nums.length];
        int[] len = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cnt[i] = 1;
            len[i] = 1;
        }
        for (int r = 1; r < nums.length; r++) {
            for (int l = 0; l < r; l++) {
                if (nums[l] < nums[r]) {
                    if (len[l] + 1 > len[r]) {
                        len[r] = len[l] + 1;
                        cnt[r] = cnt[l];
                    } else if (len[l] + 1 == len[r])
                        cnt[r] += cnt[l];
                }
            }
        }
        int longest = 1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (len[i] > longest) {
                longest = len[i];
                res = cnt[i];
            } else if (len[i] == longest)
                res += cnt[i];
        }
        return res;
    }
}

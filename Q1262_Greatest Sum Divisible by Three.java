/**
 * Created by csy99 on 5/7/20.
 */
class Solution {
    // dp
    public int maxSumDivThree(int[] nums) {
        int[] state = new int[3];
        final int INF = 10000;
        state[1] = -INF;
        state[2] = -INF;
        for (int i = 0; i < nums.length; i++) {
            int[] cur = new int[3];
            if (nums[i] % 3 == 0) { // divisible by 3, must be a part of answer
                for (int k = 0; k < 3; k++)
                    cur[k] = nums[i] + state[k];
            } else if (nums[i] % 3 == 1) {
                cur[0] = Math.max(state[0], state[2] + nums[i]);
                cur[1] = Math.max(state[1], state[0] + nums[i]);
                cur[2] = Math.max(state[2], state[1] + nums[i]);
            } else {
                cur[0] = Math.max(state[0], state[1] + nums[i]);
                cur[1] = Math.max(state[1], state[2] + nums[i]);
                cur[2] = Math.max(state[2], state[0] + nums[i]);
            }
            state = cur;    
        }
        return state[0];
    }
    
    // dp, simplify math equation
    public int maxSumDivThree(int[] nums) {
        int[] state = new int[3];
        final int INF = 10000;
        state[1] = -INF;
        state[2] = -INF;
        for (int i = 0; i < nums.length; i++) {
            int[] cur = new int[3];
            for (int k = 0; k < 3; k++) {
                int m = (k-nums[i]) % 3;
                if (m < 0) 
                    m += 3;
                cur[k] = Math.max(state[k], state[m] + nums[i]);
            }
            state = cur;    
        }
        return state[0];
    }
}


    // // Greedy is wrong
    // public int maxSumDivThree(int[] nums) {
    //     int res = 0;
    //     ArrayList<Integer> mod1 = new ArrayList();
    //     ArrayList<Integer> mod2 = new ArrayList();
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] % 3 == 0)
    //             res += nums[i];
    //         else if (nums[i] % 3 == 1)
    //             mod1.add(nums[i]);
    //         else
    //             mod2.add(nums[i]);
    //     }
    //     Collections.sort(mod1, (a,b)->(b-a));
    //     Collections.sort(mod2, (a,b)->(b-a));
    //     while (mod1.size() > 0 && mod2.size() > 0) {
    //         res += mod1.remove(0);
    //         res += mod2.remove(0);
    //     }
    //     return res;
    // }

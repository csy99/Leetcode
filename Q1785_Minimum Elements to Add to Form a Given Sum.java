/**
 * Created by csy99 on 3/6/20 during contest.
 */
class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num: nums)
            sum += num;
        long g = goal;
        if (g == sum) return 0;
        long res = (Math.abs(g-sum)-1) / limit;
        return (int)res+1;
    }
}

package Leetcode;

// always divided by a very small number
public class Q553_Optimal_Division {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0] + "";
        if (n == 2)
            return nums[0] + "/" + nums[1];
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("/(").append(nums[1]);
        for (int i = 2; i < n; i++)
            sb.append("/").append(nums[i]);
        sb.append(")");
        return sb.toString();
    }
}

package Leetcode;

/**
 * Created by csy99 on 4/19/20.
 */
public class Q307_Range_Sum_Query_Mutable {
    BIT tree;
    int[] arr;
    
    public NumArray(int[] nums) {
        arr = nums;
        tree = new BIT(nums.length);
        for (int i = 0; i < nums.length; i++)
            tree.update(i+1, nums[i]);
    }
    
    public void update(int i, int val) {
        tree.update(i+1, val - arr[i]);
        arr[i] = val;
    }
    
    public int sumRange(int i, int j) {
        return tree.query(j+1) - tree.query(i);
    }
}


class BIT {
    int[] sum;
    public BIT(int n) {
        sum = new int[n+1];
    }
    
    public void update(int i, int diff) {
        while (i < sum.length) {
            sum[i] += diff;
            i += i & (-i);
        }
    }
    
    public int query(int i) {
        int res = 0;
        while (i > 0) {
            res += sum[i];
            i -= i & (-i);
        }
        return res;
    }
}

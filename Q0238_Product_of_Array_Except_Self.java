package Leetcode;

/**
 * Created by csy99 on 3/15/20.
 */
public class Q238_Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        int zeros = 0;
        long total = 1;
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeros++;
                pos = i;
            } else
                total *= nums[i];
        }
        if (zeros > 1)
            return product;
        if (zeros == 1) {
            product[pos] = (int)total;
            return product;
        }
        for (int i = 0; i < n; i++) {
            product[i] = (int)(total/nums[i]);
        }
        return product;
    }
    
    /**
    * Created by rbhatnagar2 on 1/15/17.
    */
    public int[] productExceptSelf(int[] nums) {
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        int res[] = new int[nums.length];

        //left product
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }


        //right product
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        //product of left and right
        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}

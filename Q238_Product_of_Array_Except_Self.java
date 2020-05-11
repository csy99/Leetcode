package Leetcode;

/**
 * Created by csy99 on 3/15/20.
 */
public class Q238_Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
      int product = 1;
      int numZero = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0)
          numZero++;
        else
          product *= nums[i];
      }
      int[] res = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0 && numZero == 0)
          res[i] = product/nums[i];
        else if (nums[i] != 0 && numZero != 0)
          res[i] = 0;
        else if (nums[i] == 0 && numZero == 1)  // only one zero in the array
          res[i] = product;
        else  // multiple zeros in the array
          res[i] = 0;
      }
      return res;
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

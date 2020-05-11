package Leetcode;

/**
 * Created by csy99 on 4/17/20.
 */
public class Q318_Maximum_Product_of_Word_Lengths {
    public int maxProduct(String[] words) {
        if (words.length == 0) return 0;
        int n = words.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int flag = 0;
            for(char c: words[i].toCharArray())
                flag |= 1 << (c - 'a');
            nums[i] = flag;
        }
        int product = 0; 
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if ((nums[i] & nums[j]) == 0) 
                    product = Math.max(product, words[i].length()*words[j].length());
            }
        }
        return product;
    }
}

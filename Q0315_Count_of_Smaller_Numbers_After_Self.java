package Leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by csy99 on 3/16/20.
 */
public class Q0315_Count_of_Smaller_Numbers_After_Self {
    public List<Integer> countSmaller(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        HashMap<Integer, Integer> rank = new HashMap();
        int r = 0;
        for (int i = 0; i < sorted.length; i++) {
            if (i == 0 || sorted[i] != sorted[i-1]) // dup number share rank
                rank.put(sorted[i], ++r);
        }
        
        BIT tree = new BIT(rank.size());
        LinkedList<Integer> res = new LinkedList();
        // convert the problem to sum up the frequency of numbers smaller than itself that appear after 
        for (int i = nums.length - 1; i >= 0; i--) {
            int sum = tree.query(rank.get(nums[i]) - 1);
            res.add(0, sum);
            tree.update(rank.get(nums[i]), 1);
        }
        return res;
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
            i += (i & -i);
        }
    }
    
    public int query(int i) {
        int res = 0;
        while (i > 0) {
            res += sum[i];
            i -= (i & -i);
        }
        return res;
    }
}

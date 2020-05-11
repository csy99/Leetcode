package Leetcode;

import java.util.Random;

/**
 * Created by csy99 on 4/12/20.
 */
public class Q398_Random_Pick_Index {
    private int[] arr;
    Random rand;
    
    public Solution(int[] nums) {
        arr = nums;
        rand = new Random();
    }
    
    public int pick(int target) {
        int cnt = 0;
        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                ++cnt;
                if (rand.nextInt(cnt) == 0)
                    res = i;
            }
        }
        return res;
    }
}

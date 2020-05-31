package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by csy99 on 5/31/20.
 */
public class Q229_Majority_Element_II {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList();
        Integer a = null;
        Integer b = null;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (a != null && nums[i] == a)
                cnt1++;
            else if (b != null && nums[i] == b)
                cnt2++;
            else if (cnt1 == 0) {
                a = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0) {
                b = nums[i];
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a)
                cnt1++;
            else if (nums[i] == b)
                cnt2++;            
        }
        if (cnt1 > nums.length/3)
            res.add(a);
        if (cnt2 > nums.length/3)
            res.add(b);
        return res;
    }
}

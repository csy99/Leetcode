package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by csy99 on 12/29/20.
 */
public class Q496_Next_Greater_Element_I {
    // mono stack, time: O(n), space: O(n)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[m];
        Stack<Integer> st = new Stack();
        Map<Integer, Integer> map = new HashMap();
        for (int num: nums2) {
            while (st.size() > 0 && num > st.peek())
                map.put(st.pop(), num);
            st.push(num);
        }
        int i = 0;
        for (int num: nums1) 
            res[i++] = map.getOrDefault(num, -1);
        return res;
    }
}

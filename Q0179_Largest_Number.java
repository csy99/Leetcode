package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by csy99 on 3/18/20.
 */
public class Q0179_Largest_Number {
    public String largestNumber(int[] nums) {
        if (nums.length == 0)
            return "";
        String[] copy = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            copy[i] = String.valueOf(nums[i]);
        Arrays.sort(copy, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < copy.length; i++)
            sb.append(copy[i]);
        while (sb.length() > 1 && sb.charAt(0) == '0')  // edge case, multiple 0s
            sb.deleteCharAt(0);
        return sb.toString();
    }
}

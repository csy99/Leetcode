package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by csy99 on 8/28/20.
 */
public class Q421_Maximum_XOR_of_Two_Numbers_in_an_Array {
    /*
    This algorithm's idea is:
    to iteratively determine what would be each bit of the final result from left to right.
    And it narrows down the candidate group iteration by iteration.
    e.g. assume input are a,b,c,d,...z, 26 integers in total.
    In first iteration, if you found that a, d, e, h, u differs on the MSB(most significant bit),
    so you are sure your final result's MSB is set.
    Now in second iteration, you try to see if among a, d, e, h, u
    there are at least two numbers make the 2nd MSB differs,
    if yes, then definitely, the 2nd MSB will be set in the final result.
    And maybe at this point the candidate group shinks from a,d,e,h,u to a, e, h.
    Implicitly, every iteration, you are narrowing down the candidate group,
    but you don't need to track how the group is shrinking,
    you only cares about the final result.
     */
    // idea is that a^b=max => a^max=b
    public int findMaximumXOR(int[] nums) {
        int largest = 0;
        int mask = 0;
        for (int d = 30; d >= 0; d--) {
            int cur = 1 << d; 
            mask |= cur;
            HashSet<Integer> set = new HashSet(); 
            for (int num: nums)
                set.add(mask & num);
            for (int val: set) {  // val serves as a
                if (set.contains(val ^ (largest|cur))) {  // largest|cur serves as max, find if b is in the set
                    largest |= cur;
                    break;
                }
            }
        }
        return largest;
    }
}

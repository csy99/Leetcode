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

// Solution 2: Trie
class Solution {
    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num: nums)
            root.insert(root, num);
        int res = 0;
        for (int num: nums)
            res = Math.max(res, root.query(root, num));
        return res;
    }
}

class TrieNode {
    TrieNode[] children;
    
    public TrieNode() {
        children = new TrieNode[2];
    }
    
    public void insert(TrieNode root, int num) {
        TrieNode node = root;
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null)
                node.children[bit] = new TrieNode();
            node = node.children[bit];
        }
    }
    
    public int query(TrieNode root, int num) {
        TrieNode node = root;
        int sum = 0;
        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[1 - bit] != null) {
                sum |= (1 << i);
                node = node.children[1 - bit];
            } else
                node = node.children[bit];
        }
        return sum;
    }
}

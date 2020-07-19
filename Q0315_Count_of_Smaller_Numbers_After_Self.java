package Leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by csy99 on 3/16/20.
 */
class Node {
    int val;
    int idx;
    
    public Node (int v, int i) {
        val = v;
        idx = i;
    }
}

public class Q0315_Count_of_Smaller_Numbers_After_Self {
    // merge sort
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        List<Integer> res = new ArrayList();
        if (n == 0) return res;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++)
            nodes[i] = new Node(nums[i], i);
        mergesort(nodes, 0, n-1);
        for (int c: count)
            res.add(c);
        return res;
    }
    
    private Node[] mergesort(Node[] nodes, int l, int r) {
        if (l == r)
            return new Node[] {nodes[l]};
        int mid = (r - l) / 2 + l;
        Node[] first = mergesort(nodes, l, mid);
        Node[] second = mergesort(nodes, mid+1, r);
        Node[] merged = new Node[r-l+1];
        int i = 0, j = 0, k = 0;
        int reversed = 0;
        while (i < first.length && j < second.length) {
            if (first[i].val > second[j].val) {
                reversed++;
                merged[k++] = second[j++];
            } else {
                count[first[i].idx] += reversed;
                merged[k++] = first[i++];
            }
        }
        while (i < first.length) {
            count[first[i].idx] += reversed;
            merged[k++] = first[i++];
        }
        while (j < second.length) 
            merged[k++] = second[j++];
        return merged;
    }
    
    // BIT
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

/**
 * Created by csy99 on 9/2/21.
 */
// sort, time: O(n log n), space: O(1)
class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i-1]) {
                res += nums[i-1] - nums[i] + 1;
                nums[i] = nums[i-1] + 1;
            }
        }
        return res;
    }
}

// TreeMap, time: O(n log k), space: O(n)
class Solution {
    TreeMap<Integer, Integer> counts = new TreeMap();
    public int minIncrementForUnique(int[] nums) {
        int res = 0;
        int need = 0;
        for (int num: nums) 
            counts.put(num, counts.getOrDefault(num,0)+1);    
        for (int num: counts.keySet()) {
            int cnt = counts.get(num);
            res += cnt * Math.max(0, need - num) + cnt * (cnt-1) / 2;
            need = Math.max(need, num) + cnt;
        }
        return res;
    }
}

// union find, time: O(amortized n), space: O(n)
class Solution {
    Map<Integer, Integer> parent = new HashMap();
    public int minIncrementForUnique(int[] nums) {
        int res = 0;
        for (int num: nums)
            res += find(num) - num;
        return res;
    }
    
    private int find(int x) {
        int res = x;
        if (!parent.containsKey(x))
            parent.put(x, x);
        else {
            res = find(parent.get(x)+1);
            parent.put(x, res);
        }
        return res;
    }
}

class Solution {
    // counting sort, time: O(n + m), space: O(n)
    public int minIncrementForUnique(int[] nums) {
        int res = 0;
        int N = (int) 1e5;
        int[] counts = new int[N+2];
        int hi = 0;
        int lo = N+1;
        for (int num: nums) {
            counts[num] ++;
            hi = Math.max(hi, num);
            lo = Math.min(lo, num);
        }
        for (int i = lo; i < hi; i++) {
            if (counts[i] <= 1) continue;
            int diff = counts[i] - 1;
            res += diff;
            counts[i+1] += diff;
            // counts[i] = 1; 
        }
        int cnt = counts[hi];
        res += cnt * (cnt-1) / 2;
        return res;
    }
    
}

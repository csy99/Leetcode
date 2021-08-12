/**
 * Created by csy99 on 8/11/21.
 
 You are given an array of positive/negative numbers that are not necessarily distinct. We have to return the number of contiguous subarrays that contain at least one of each number (i.e. only duplicates).

Examples:

[0, 0, 0] => 3: first two 0s, second and third 0, and entire array
[1, 2, 3] => 0
[1, 2, 3, 3, 3, 2, 4, 1] => 4: [3, 3] (first), [3, 3] (second), [3, 3, 3], [2, 3, 3, 3, 2]
[1, 2, 1, 2] => 1: only the entire array works here
arr.length <= 10^3

 */
public class Solution {
    public int contiguous(int[] arr) {
        int res = 0;
        int n = arr.length; 
        for (int r = 0; r < n; r++) { 
            Map<Integer, Integer> cnt = new HashMap();   
            int single = 0;
            for (int l = r; l >= 0; l--) {
                int num = arr[l];
                int c = cnt.getOrDefault(num, 0);
                cnt.put(num, c + 1);
                if (c == 0)
                    single ++;
                else if (c == 1)
                    single --;
                if (single == 0)
                    res ++;
            }
        }
        return res;
    }
}



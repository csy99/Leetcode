/**
 * Created by csy99 on 8/11/21.
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



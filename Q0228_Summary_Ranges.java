package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/15/20.
 */
public class Q228_Summary_Ranges {
    List<String> res = new ArrayList();
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        if (n == 0) return res;
        long start = (long)nums[0];
        long end = (long)nums[0];
        for (int i = 1; i < n; i++) {
            if ((long)nums[i] == end+1)
                end = (long)nums[i];
            else {
                addRange(start, end);
                start = (long)nums[i];
                end = (long)nums[i];
            }
        }
        addRange(start, end);
        return res;
    }
    
    private void addRange(long l, long r) {
        if (l > r) return;
        if (l == r)
            res.add(String.valueOf(l));
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(l).append("->").append(r);
            res.add(sb.toString());
        }
    }
}

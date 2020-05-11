package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 4/15/20.
 */
public class Q264_Ugly_Number_II {
    public int nthUglyNumber(int n) {
        ArrayList<Integer> list = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        list.add(1);
        while (list.size() < n) {
            int next2 = list.get(i2)*2;
            int next3 = list.get(i3)*3;
            int next5 = list.get(i5)*5;
            int ugly = Math.min(next2, Math.min(next3, next5));
            if (ugly == next2)
                i2++;
            if (ugly == next3)
                i3++;
            if (ugly == next5)
                i5++;
            list.add(ugly);
        }
        return list.get(n-1);
    }
}

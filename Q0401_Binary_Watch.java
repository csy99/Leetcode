/**
 * Created by csy99 on 8/25/20.
 */
public class Q401_Binary_Watch {
class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList();
        if (num == 0) {
            res.add("0:00");
            return res;
        }
        StringBuilder sb = new StringBuilder();
        for (int h = 0; h < 12; h++) 
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
                    sb.setLength(0);
                    sb.append(h).append(":");
                    if (m < 10)
                        sb.append("0");
                    sb.append(m);
                    res.add(sb.toString());
                }
            }
        return res;
    }
}
}

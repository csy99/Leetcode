/**
 * Created by csy99 on 9/26/21.
 */
public class Solution {
    public List<Integer> getLexi(int n) {
        List<Integer> res = new ArrayList();
        for (int first = 1; first < 10; first++) {
            int base = 1;
            while (base <= n) {
                for (int i = 0; i < base; i++) {
                    if (first*base+i > n)
                        break;
                    res.add(first*base+i);
                }
                base *= 10;
            }
        }
        return res;
    }
}

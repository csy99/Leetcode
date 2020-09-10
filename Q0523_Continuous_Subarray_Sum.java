/**
 * Created by csy99 on 9/9/20.
 */
public class Q523_Continuous_Subarray_Sum {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        int n = nums.length;
        int sum = 0;
        map.put(0, 0);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                int front = map.get(sum);
                if (i-front+1 > 1)
                    return true;
            }
            map.putIfAbsent(sum, i+1);
        }
        return false;
    }
}

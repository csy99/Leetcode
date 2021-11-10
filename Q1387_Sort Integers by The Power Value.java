/**
 * Created by csy99 on 11/9/21.
 */
class Solution {
    Map<Integer, Integer> steps = new HashMap();
    public int getKth(int lo, int hi, int k) {
        steps.put(1,0);
        List<Integer> nums = new ArrayList();
        for (int num = lo; num <= hi; num++) {
            nums.add(num);
            helper(num);
        }
        Collections.sort(nums, (a,b) -> steps.get(a)!=steps.get(b) ? steps.get(a)-steps.get(b) : Integer.compare(a,b));
        return nums.get(k-1);
    }
    
    private int helper(int num) {
        if (steps.containsKey(num))
            return steps.get(num);
        if ((num & 1) == 0)
            steps.put(num, helper(num/2) + 1);
        else
            steps.put(num, helper(3*num+1)+1);
        return steps.get(num);
    }
}

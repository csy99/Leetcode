/**
 * Created by csy99 on 9/13/20.
 */
class Solution {
    public int numFriendRequests(int[] ages) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int age: ages)
            map.put(age, map.getOrDefault(age, 0) + 1);
        int res = 0;
        for (int age1: map.keySet()) {
            int cnt1 = map.get(age1);
            for (int age2: map.keySet()) {
                int cnt2 = map.get(age2);
                if (request(age1, age2)) {
                    res += cnt1 * cnt2;
                    if (age2 == age1) 
                        res -= cnt1;
                }
            }
        }
        return res;
    }
    
    private boolean request(int a, int b) {
        if (b <= 0.5 * a + 7)
            return false;
        if (b > a)
            return false;
        return true;
    }
}

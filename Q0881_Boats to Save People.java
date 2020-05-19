/**
 * Created by csy99 on 5/19/20.
 */
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        if (people.length == 0) return 0;
        Arrays.sort(people);
        int l = 0;
        int r = people.length-1;
        int times = 0;
        while(l < r) {
            if (people[l] + people[r] <= limit)
                l++;
            r--;
            times++;
        }
        if (l == r)
            times++;
        return times;
    }
}

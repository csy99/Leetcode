/**
 * Created by csy99 on 10/1/21.
 * https://leetcode.com/problems/maximum-number-of-visible-points/discuss/877845/JAVA-Sliding-Window
 */
 
class Solution {
    public int visiblePoints(List<List<Integer>> points, int vision, List<Integer> location) {
        List<Double> angles = new ArrayList();
        int samePosition = 0;
        int x = location.get(0);
        int y = location.get(1);
        for (List<Integer> p: points) {
            int dx = p.get(0) - x;
            int dy = p.get(1) - y;
            if (dx == 0 && dy == 0) {
                samePosition++;
                continue;
            }
            angles.add(Math.atan2(dy, dx) / Math.PI * 180);
        }
        Collections.sort(angles);
        int res = 0;
        List<Double> dummy_angles = new ArrayList(angles);
        for (double angle: angles) dummy_angles.add(360 + angle);
        for (int i = 0, j = 0; i < dummy_angles.size(); i++) {
            while (dummy_angles.get(i) - dummy_angles.get(j) > vision)
                j++;
            res = Math.max(res, i - j + 1);
        }
        return res + samePosition;
    }
}

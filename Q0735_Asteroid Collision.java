/**
 * Created by csy99 on 10/1/21.
 */
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack();
        for (int asteroid: asteroids) {
            if (st.size() == 0 || st.peek() < 0 || asteroid > 0) {
                st.push(asteroid);
                continue;
            }
            int cur = asteroid; 
            // current moving left, previous moving right
            while (st.size() > 0 && st.peek() > 0) {
                int pre = st.pop();
                if (pre > -cur) {
                    cur = pre;
                    break;
                } else if (pre == -cur) {
                    cur = 0;
                    break;
                } 
            }
            if (cur != 0)
                st.push(cur);
        }
        int[] res = new int[st.size()];
        int pos = res.length-1;
        while (pos >= 0)
            res[pos--] = st.pop();
        return res;
    }
}

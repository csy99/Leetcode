/**
 * Created by csy99 on 9/18/20.
 */
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int lastTime = 0;
        Stack<Integer> st = new Stack();
        int[] res = new int[n];
        for (String log: logs) {
            String[] component = log.split(":");
            int id = Integer.parseInt(component[0]);
            int time = Integer.parseInt(component[2]);
            if (component[1].equals("start")) {
                if (st.size() > 0) 
                    res[st.peek()] += time - lastTime;
                st.push(id);
                lastTime = time;
            } else {
                res[st.pop()] += time - lastTime + 1;
                lastTime = time + 1;
            }
        }
        return res;
    }
}

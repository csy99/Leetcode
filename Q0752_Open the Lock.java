class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> dead = new HashSet();
        for (int i = 0; i < deadends.length; i++)
            dead.add(deadends[i]);
        if (dead.contains(target) || dead.contains("0000"))
            return -1;
        int step = 0;
        Queue<String> q = new LinkedList();
        HashSet<String> visited = new HashSet();
        q.add("0000");
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int s = 0; s < size; s++) {
                String cur = q.poll();
                if (dead.contains(cur)) continue;
                char[] arr = cur.toCharArray();
                for (int i = 0; i < 4; i++) {
                    char copy = arr[i];
                    int up = arr[i] == '9' ? 0 : (arr[i] - '0') + 1;
                    int down = arr[i] == '0' ? 9 : (arr[i] - '0') - 1;
                    arr[i] = (char)(up + '0');
                    String nxtUp = new String(arr);
                    arr[i] = (char)(down + '0');
                    String nxtDown = new String(arr);
                    if (target.equals(nxtUp) || target.equals(nxtDown))
                        return step;
                    if (!dead.contains(nxtUp) && !visited.contains(nxtUp)) {
                        q.add(nxtUp);
                        visited.add(nxtUp);
                    }
                    if (!dead.contains(nxtDown) && !visited.contains(nxtDown)) {
                        q.add(nxtDown);
                        visited.add(nxtDown);
                    }
                    arr[i] = copy;
                }
            }
            
        }
        return -1;
    }
}

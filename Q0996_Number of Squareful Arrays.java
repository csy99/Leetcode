class Solution {
    int res = 0;
    int n;
    int[] arr;
    boolean[] used;
    public int numSquarefulPerms(int[] A) {
        n = A.length;
        if (n == 0)
            return 0;
        arr = A;
        Arrays.sort(arr);
        used = new boolean[n];
        dfs(new ArrayList());
        return res;
    }
    
    private void dfs(ArrayList<Integer> path) {
        if (path.size() == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            if (i > 0 && !used[i-1] && arr[i] == arr[i-1]) continue;
            if (path.size() > 0 && !isSquare(path.get(path.size()-1), arr[i]))
                continue;
            path.add(arr[i]);
            used[i] = true;
            dfs(path);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
    
    private boolean isSquare(int a, int b) {
        double root = Math.sqrt(a+b);
        if (Math.abs(root - (int)root) < 0.0001)
            return true;
        return false;
    }
}

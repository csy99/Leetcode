/**
 * Created by csy99 on 5/15/20.
 */
class Solution {
    List<Integer> res = new ArrayList();
    int n;
    String s;
    public List<Integer> splitIntoFibonacci(String S) {
        n = S.length();
        s = S;
        dfs(0);
        return res;
    }
    
    private boolean dfs(int start) {
        if (start == n) {
            if (res.size() > 2)
                return true;
            return false;
        }
        int maxLen = s.charAt(start) == '0' ? 1 : 10;
        long num = 0;
        for (int i = start; i < Math.min(start+maxLen, n); i++) {
            num = num*10 + (s.charAt(i) - '0');
            if (num > Integer.MAX_VALUE) break;
            if (res.size() >= 2) {
                if (num > res.get(res.size()-1) + res.get(res.size()-2))
                    break;
                else if (num < res.get(res.size()-1) + res.get(res.size()-2))
                    continue;
            } 
            res.add((int)num);
            if (dfs(i+1)) return true;
            res.remove(res.size()-1);
        }
        return false;
    }
}

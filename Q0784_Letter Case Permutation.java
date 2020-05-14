/**
 * Created by csy99 on 5/13/20. 
 */
class Solution {
    List<String> res = new ArrayList();
    int n;
    String str;
    public List<String> letterCasePermutation(String S) {
        n = S.length();
        str = S;
        if (n == 0) return res;
        dfs(new StringBuilder(), 0);
        return res;
    }
    
    private void dfs(StringBuilder sb, int start) {
        if (sb.length() == n) {
            res.add(sb.toString());
            return;
        }
        char c = str.charAt(start);
        if (Character.isDigit(c)) {
            sb.append(c);
            dfs(sb, start+1);
            sb.deleteCharAt(sb.length()-1);
        } else {
            dfs(sb.append(Character.toLowerCase(c)), start+1);
            sb.deleteCharAt(sb.length()-1);
            dfs(sb.append(Character.toUpperCase(c)), start+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

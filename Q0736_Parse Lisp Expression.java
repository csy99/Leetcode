/**
 * Created by csy99 on 9/29/21.
 * https://leetcode.com/problems/parse-lisp-expression/discuss/113902/A-Clean-Java-Solution
 */
class Solution {
    StringBuilder sb = new StringBuilder();
    public int evaluate(String expression) {
        return eval(expression, new HashMap());
    }
    
    private int eval(String exp, Map<String, Integer> parent) {
        char first = exp.charAt(0);
        if (first != '(') {
            // get number
            if (Character.isDigit(first) || first == '-')
                return Integer.parseInt(exp);
            return parent.get(exp);
        }
        // create a new scope, and add all previous values
        Map<String, Integer> cur = new HashMap(parent);
        List<String> tokens = parse(exp.substring(exp.charAt(1) == 'm' ? 6 : 5, exp.length()-1));
        if (exp.startsWith("(a"))
            return eval(tokens.get(0), cur) + eval(tokens.get(1), cur);
        if (exp.startsWith("(m"))
            return eval(tokens.get(0), cur) * eval(tokens.get(1), cur);
        int m = tokens.size();
        for (int i = 0; i < m - 2; i += 2)
            cur.put(tokens.get(i), eval(tokens.get(i+1), cur));
        return eval(tokens.get(m-1), cur);
    }
    
    // separate the values btw two parentheses
    private List<String> parse(String str) {
        List<String> res = new ArrayList();
        int lv = 0;
        sb.setLength(0);
        for (char c: str.toCharArray()) {
            if (c == '(')
                lv++;
            else if (c == ')')
                lv--;
            
            if (lv == 0 && c == ' ') {
                res.add(sb.toString());
                sb.setLength(0);
            } else
                sb.append(c);
        }
        if (sb.length() > 0)
            res.add(sb.toString());
        return res;
    }
}

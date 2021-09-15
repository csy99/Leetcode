/**
 * Created by csy99 on 9/14/21.
 */
class Solution {
    public static void main(String[] args) {
        String str = "((a){2}b(de){3}){2}";
        System.out.println(decode(str));
        // aa b dedede aa b dedede
    }

    private static String decode(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack();
        int n = str.length();
        int i = 0;
        while (i < n) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < n && Character.isDigit(str.charAt(i))) {
                    num = num * 10 + (str.charAt(i) - '0');
                    i++;
                }
                String cur = sb.toString();
                StringBuilder tmp = new StringBuilder();
                for (int j = 0; j < num; j++)
                    tmp.append(cur);
                String prefix = st.size() > 0 ? st.pop() : "";
                tmp.insert(0, prefix);
                sb = tmp;
            } else if (c == '(') {
                st.push(sb.toString());
                sb.setLength(0);
            } else if (Character.isLetter(c))
                sb.append(c);
            i++;
        }
        return sb.toString();
    }
}

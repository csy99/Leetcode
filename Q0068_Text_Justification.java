package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 8/24/20.
 */
public class Q068_Text_Justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> res = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int gaps = 0;  // 每行需要分成几组分割空格
        
        while (idx < n) {
            sb.setLength(0);
            int numChar = words[idx].length();
            int last = idx + 1;
            while (last < n) {
                if (numChar + words[last].length() + 1 > maxWidth)
                    break;
                numChar += words[last].length() + 1;
                last++;
            } 
            gaps = last - idx - 1;
            if (last == n || gaps == 0) { //左对齐
                for (int i = idx; i < last-1; i++) {
                    sb.append(words[i]);
                    sb.append(" ");
                }
                sb.append(words[last-1]);
                while (sb.length() < maxWidth)
                    sb.append(" ");
            } else {  //两端对齐
                int base = (maxWidth - numChar) / gaps;
                int rest = (maxWidth - numChar) % gaps;
                for (int i = idx; i < last-1; i++) {
                    sb.append(words[i]);
                    sb.append(" ");
                    // 多余空格尽量往前分配
                    for (int j = 0; j < base + (i-idx < rest ? 1 : 0); j++)
                        sb.append(" ");
                }
                sb.append(words[last-1]);
            }
            res.add(sb.toString());
            idx = last;
        }
        return res;
    }

    public static void main(String[] args) {
        Q068_Text_Justification sol = new Q068_Text_Justification();
        String[] words = {"Tushar", "Roy", "likes", "to", "code"};
        List<String> res = sol.fullJustify(words, 10);
        for (String str : res)
            System.out.println(str);
    }
}

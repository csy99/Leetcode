package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/19/20.
 */
public class Q271_Encode_and_Decode_Strings {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            sb.append(strs.get(i).length());
            sb.append(";").append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList();
        int i = 0;
        while (i < str.length()) {
            int len = str.charAt(i) - '0';
            while (i+1 < str.length() && str.charAt(i+1) != ';') {
                i++;
                len = len*10 + str.charAt(i) - '0';
            }
            i++;  // i points to delimeter
            String sub = str.substring(i+1, i+len+1);
            res.add(sub);
            i += len + 1;
        }
        return res;
    }
}

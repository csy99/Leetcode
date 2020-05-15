package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csy99 on 3/27/20.
 */
public class Q093_Restore_IP_Addresses {
    // ip rule: four fields, with at most three digits in each field
    // each field cannot start with 0 (unless the whole field contains only one 0) or larger than 255
    List<String> res = new ArrayList();
    public List<String> restoreIpAddresses(String s) {
        dfs(new StringBuilder(), 0, s);
        return res;
    }
    
    private void dfs(StringBuilder ip, int part, String str) {
        int strLen = str.length();
        int len = ip.length();
        if (part == 4 || strLen == 0) {
            if (0 == strLen && part == 4)
                res.add(ip.toString());
            return;
        }
        for (int i = 1; i <= Math.min(3, str.charAt(0) == '0' ? 1 : strLen); i++) {
            String sub = str.substring(0, i);
            if (i == 3 && Integer.parseInt(sub) > 255) 
                break;
            if (len > 0)
                ip.append(".");
            ip.append(sub);
            dfs(ip, part+1, str.substring(i));
            ip.setLength(len);
        }
    }
    
}

package Leetcode;

/**
 * Created by csy99 on 8/27/20.
 */
public class Q420_Strong_Password_Checker {
    public int strongPasswordChecker(String s) {
        int n = s.length();
        int needTypes = missingTypes(s);
        List<Integer> repeatLens = countRepeat(s);
        if (n < 6)
            return Math.max(needTypes, 6 - n);
        if (n >= 6 && n <= 20) {
            int swap = 0;
            for (int len: repeatLens)
                swap += len / 3;
            return Math.max(needTypes, swap);
        }
        int needRemove = n - 20;
        int m = repeatLens.size();
        for (int i = 0; i < m; i++) {
            if (needRemove <= 0) break;
            int len = repeatLens.get(i);
            if (len % 3 == 0) {
                needRemove -= 1;
                repeatLens.set(i, len-1);
            }
        }
        for (int i = 0; i < m; i++) {
            if (needRemove <= 0) break;
            int len = repeatLens.get(i);
            if (len % 3 == 1 && needRemove >= 2) {
                needRemove -= 2;
                repeatLens.set(i, len-2);
            }
        }
        for (int i = 0; i < m; i++) {
            if (needRemove <= 0) break;
            int len = repeatLens.get(i);
            if (len >= 3 && needRemove >= 3) {
                needRemove -= 3;
                repeatLens.set(i, len-3);
            }
        }
        int swap = 0;
        for (int len: repeatLens)
            swap += len / 3;
        return Math.max(needTypes, swap) + n - 20;
        
    }
    
    private int missingTypes(String s) {
        int upper = 1;
        int lower = 1;
        int num = 1;
        for (char c: s.toCharArray()) {
            if (c >= 'a' && c <= 'z')
                lower = 0;
            else if (c >= 'A' && c <= 'Z')
                upper = 0;
            else if (c >= '0' && c <= '9')
                num = 0;
        }
        return upper + lower + num;
    }
    
    private List<Integer> countRepeat(String s) {
        List<Integer> res = new ArrayList();
        int n = s.length();
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i-1))
                cnt++;
            else {
                if (cnt >= 3)
                    res.add(cnt);
                cnt= 1;
            }
        }
        if (cnt >= 3)
            res.add(cnt);
        return res;
    }
}

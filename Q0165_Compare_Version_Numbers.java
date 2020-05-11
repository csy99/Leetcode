package Leetcode;

/**
 * Created by csy99 on 4/13/20.
 */
public class Q165_Compare_Version_Numbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int n1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int n2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (n1 < n2)
                return -1;
            if (n2 < n1)
                return 1;
        }
        return 0;
    }
}

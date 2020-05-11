/**
 * Created by csy99 on 5/4/20. 
 */
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] len = new int[m+1][n+1];
        int i = 1;
        int j = 1;
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1))
                    len[i][j] = len[i-1][j-1] + 1;
                else
                    len[i][j] = Math.max(len[i-1][j], len[i][j-1]);
            }
        i--;
        j--;
        StringBuilder sb = new StringBuilder();
        while (i > 0 || j > 0) {
            char c = '*';
            if (i == 0) {  // the first str1 is completely matched
                c = str2.charAt(j-1);
                j--;
            } else if (j == 0) {
                c = str1.charAt(i-1);
                i--;
            } else if (str1.charAt(i-1) == str2.charAt(j-1)) {  // current char can match both
                c = str1.charAt(i-1);
                i--;
                j--;
            } else if (len[i][j] == len[i-1][j]) {  // need to match str1
                c = str1.charAt(i-1);
                i--;                
            } else {
                c = str2.charAt(j-1);
                j--;                
            }
            sb.insert(0, c);
        }
        return sb.toString();
    }
}

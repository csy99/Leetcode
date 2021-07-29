/**
 * Created by csy99 on 7/29/21.
 */
class Solution {
    public boolean isRobotBounded(String instructions) {
        int n = instructions.length();
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < 4; c++)
            sb.append(instructions);
        String str = sb.toString();
        int y = 0;
        int x = 0;
        int d = 0;
        int[][] dirs = new int[][] {{-1,0},{0,1},{1,0},{0,-1}}; // u r d l
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch(c) {
                case 'G':
                    y += dirs[d][0];
                    x += dirs[d][1];
                    break;
                case 'R':
                    d ++;
                    d %= 4;
                    break;
                case 'L':
                    d --;
                    d = (d+4) % 4;
                    break;
            }
            if ((i+1) % n == 0 && y == 0 && x == 0 && d == 0) 
                return true;
        }
        return false;
    }
}

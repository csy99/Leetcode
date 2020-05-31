/**
 * Created by csy99 on 5/30/20 during contest.
 */
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int kMod = 1_000_000_007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long height = 0;
        long pre = 0;
        for (int hori: horizontalCuts) {
            height = Math.max(height, (hori-pre)%kMod);
            pre = hori;
        }
        height = Math.max(height, (h-pre)%kMod);
        
        long width = 0;
        pre = 0;
        for (int vert: verticalCuts) {
            width = Math.max(width, (vert-pre)%kMod);
            pre = vert;
        }
        width = Math.max(width, (w-pre)%kMod);
        return (int) ((width * height)%kMod);
    }
}

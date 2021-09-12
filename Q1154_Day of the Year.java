/**
 * Created by csy99 on 9/11.
 */
class Solution {
    public int dayOfYear(String date) {
        String[] arr = date.split("-");
        int year = Integer.parseInt(arr[0]);
        int month = Integer.parseInt(arr[1]);
        int day = Integer.parseInt(arr[2]);
        int res = 0;
        int[] cnt = new int[12];
        Arrays.fill(cnt, 30);
        cnt[1] = cnt[3] = cnt[5] = cnt[7] = cnt[8] = cnt[10] = 31;
        cnt[2] = 28;
        for (int i = 1; i < month; i++) {
            if (i == 2) {
                if (year % 100 != 0 && year % 4 == 0 || year % 400 == 0)
                    res++;
            }
            res += cnt[i];
        }
        return res + day;
    }
}

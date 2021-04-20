package Leetcode;

/**
 * Created by csy99 on 4/19/21.
 */
class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0;
        while (i < n) {
            int end = Math.min(i+k-1 ,n-1);
            reverseRange(arr, i, end);
            i += 2*k;
        }
        return new String(arr);
    }
    
    private void reverseRange(char[] arr, int s, int e) {
        int l = s;
        int r = e;
        while (l < r) {
            char c = arr[l];
            arr[l] = arr[r];
            arr[r] = c;
            l++;
            r--;
        }
    }
}

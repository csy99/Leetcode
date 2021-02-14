/**
 * Created by csy99 on 2/13/21 during contest.
 */
class Solution {
//     public int minOperations(String s) {
//         int n = s.length();
//         if (n <= 1) return 0;
//         char[] arr = s.toCharArray();
//         int res = 0;
//         int[] odd = new int[2];
//         int[] even = new int[2];
//         boolean alternate = true;
//         for (int i = 0; i < n; i++) {
//             if (i % 2 == 1) {
//                 odd[arr[i] - '0']++;
//             } else {
//                 even[arr[i] - '0']++;
//             }
//         }
        
//         return Math.min(odd[0]+even[1], odd[1]+even[0]);
//     }
    
    public int minOperations(String s) {
        int n = s.length();
        int res = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (arr[i]-'0' != i%2) 
                res++;
        }
        return Math.min(res, n-res);
    }
}

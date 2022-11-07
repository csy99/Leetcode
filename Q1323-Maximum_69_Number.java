// Convert to iterations.
// time: O(L), space: O(L)
class Solution {
    public int maximum69Number (int num) {
        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '6') {
                arr[i] = '9';
                return Integer.parseInt(new String(arr));
            }
        }
        return num;
    }
}

// Remainder.
// time: O(L), space: O(1)
class Solution {
    public int maximum69Number (int num) {
        int copy = num;
        int highestIdx = -1;
        int digit = 0;
        while (copy > 0) {
            if (copy % 10 == 6) {
                highestIdx = digit;
            }
            copy /= 10;
            digit++;
        }
        if (highestIdx >= 0)
            num += (int)Math.pow(10, highestIdx) * 3;
        return num;
    }
}

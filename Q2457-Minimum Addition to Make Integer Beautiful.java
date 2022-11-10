/**
 * Created by csy99 on 11/9/22.
 */
// mock queue, TLE
// time: O(L), space: O(L)
class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long digitSum = 0;
        long numCopy = n;
        List<Integer> digits = new ArrayList();
        while (numCopy > 0) {
            int cur = (int)(numCopy % 10);
            digitSum += cur;
            numCopy /= 10;
            digits.add(cur);
        }
        
        long res = 0;
        long prod = 10;
        while (digitSum > target) {
            int cur = digits.remove(0);
            res += prod - cur * prod / 10;
            digitSum -= cur;
            digitSum += 1;
            boolean all_nine = true;
            while (!digits.isEmpty()) {
                prod *= 10;
                int top = digits.get(0);
                if (top != 9) {
                    all_nine = false;
                    digits.set(0, top+1);
                    break;
                } else {
                    digits.remove(0);
                }
            }
            if (all_nine) digits.add(1);
        }
        return res;
    }
}

// Optimized
// time: O(log n log n), space: O(1)
class Solution {
    
    private int digitSum(long num) {
        int digitSum = 0;
        while (num > 0) {
            digitSum += (int)(num % 10);
            num /= 10;
        }
        return digitSum;
    }
    
    public long makeIntegerBeautiful(long n, int target) {
        long numCopy = n;
        long res = 0;
        long base = 1;
        while (digitSum(n) > target) {
            n /= 10;
            n += 1;
            base *= 10;
        }
        return n * base - numCopy;
    }
}

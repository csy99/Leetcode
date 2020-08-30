package Leetcode;

/**
 * Created by csy99 on 8/30/20.
 */
public class Q423_Reconstruct_Original_Digits_from_English {
    /**
     zero -> z
     one: o // 0, 1, 2, 4
     two -> w
     three: h // 3,8
     four -> u
     five: f // 4, 5 
     six -> x
     seven: s // 6, 7 
     eight -> g
     nine: i // 5, 6, 8, 9
     */
    public String originalDigits(String s) {
        int[] digits = new int[10];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'z') digits[0]++;
            if (c == 'w') digits[2]++;
            if (c == 'u') digits[4]++;
            if (c == 'x') digits[6]++;
            if (c == 'g') digits[8]++;
            if (c == 'o') digits[1]++;
            if (c == 'h') digits[3]++;
            if (c == 'f') digits[5]++;
            if (c == 's') digits[7]++;
            if (c == 'i') digits[9]++;
        }
        digits[1] -= (digits[0] + digits[2] + digits[4]);
        digits[3] -= digits[8];
        digits[5] -= digits[4];
        digits[7] -= digits[6];
        digits[9] -= (digits[5] + digits[6] + digits[8]);
        StringBuilder sb = new StringBuilder();
        for (int d = 0; d < 10; d++) 
            for (int i = 0; i < digits[d]; i++)
                sb.append(d);
        
        return sb.toString();
    }
}

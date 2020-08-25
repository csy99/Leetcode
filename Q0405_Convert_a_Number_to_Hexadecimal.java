package Leetcode;

/**
 * Created by csy99 on 8/25/20.
 */
public class Q405_Convert_a_Number_to_Hexadecimal {
    public String toHex(int num) {
        if (num == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        final String HEX = "0123456789abcdef"; 
        int round = 0;
        while (round < 8 && num != 0) {
            char c = HEX.charAt(num & 15);
            num >>>= 4;
            sb.insert(0, c);
            round++;
        }
        return sb.toString();
    }
}

package Leetcode;

/**
 * Created by csy99 on 8/27/20.
 */
public class Q434_Number_of_Segments_in_a_String {
    public int countSegments(String s) {
        s = s.trim();
        int n = s.length();
        if (n == 0)
            return 0;
        int count = 1;
        for (int i = 0; i < n-1; i++) {
            if (s.charAt(i) != ' ' && s.charAt(i + 1) == ' ')
                count++;
        }
        return count;
    }
    
    public int countSegments(String s) {
        s = s.strip();
        if (s.isEmpty()) return 0;
        String[] arr = s.split("\\s+");
        return arr.length;
    }
}

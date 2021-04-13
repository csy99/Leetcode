package Leetcode;

/**
 * Created by csy99 on 4/13/21.
 */
public class Q551_Student_Attendance_Record_I {
    public boolean checkRecord(String s) {
        if (s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"))
            return false;
        return true;
    }
    
    public boolean checkRecord(String s) {
        int cnt_absent = 0;
        int consec_late = 0;
        for (char c: s.toCharArray()) {
            if (c == 'A') {
               cnt_absent++;
                consec_late = 0;
            } else if (c == 'L')
                consec_late++;
            else
                consec_late = 0;
            if (cnt_absent >= 2) return false;
            if (consec_late >= 3) return false;
        }
        if (cnt_absent >= 2) return false;
        if (consec_late >= 3) return false;
        return true;
    }
}

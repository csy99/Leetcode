package Leetcode;

/**
 * Created by csy99 on 3/19/20.
 */

/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read.
 * For example, it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * Note:
 * The read function may be called multiple times.
 */
public class Q158_Read_N_Characters_Given_Read4_II_Call_multiple_times {
    int pos = 0;
    int cnt = 0;
    char[] cur = new char[4];
    public int read(char[] buf, int n) {
        int total = 0;  // # of chars we have read
        while (total < n) {
            if (pos == 0)
                cnt = read4(cur);
            if (cnt == 0)  // cannot read from file any more
                break;
            while (total < n && pos < cnt)
                buf[total++] = cur[pos++];
            if (pos >= cnt)  // consume all chars in this read
                pos = 0;
            if (cnt < 4)  // exit the loop earlier by catching last read
                break;
        }
        return total;
    }
}

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
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buff = new char[4];

    public int read(char[] buf, int n) {
        int total = 0;  // # of chars we have read
        while (total < n) {
            if (buffPtr == 0) 
                buffCnt = read4(buff);
            
            if (buffCnt == 0) break;  // cannot read from file any more
            while (total < n && buffPtr < buffCnt) {
                buf[total++] = buff[buffPtr++];
            }
            if (buffPtr >= buffCnt) buffPtr = 0;  // consume all chars in this read
            if (buffCnt < 4) break;  // exit the loop earlier by catching last read
        }
        return total;
    }

    private int read4(char[] buff) {
        return 1;
    }
}

package Leetcode;

/**
 * Created by csy99 on 3/19/20.
 * <p>
 * The API: int read4(char[] buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read.
 * For example, it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function
 * int read(char[] buf, int n) that reads n characters from the file.
 */
public class Q157_Read_N_Characters_Given_Read4 {
    /**
     * buf: destination buffer
     * n:   number of chars to read
     * @return: The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int len = 0;
        for (int i = 0; i < n; i += 4) {
            char[] tmp = new char[4];
            len = read4(tmp);
            // source, s_start, target, t_start, len
            System.arraycopy(tmp, 0, buf, i, Math.min(n-i, len));
            if (len < 4) return Math.min(i+len, n);
        }
        return n;
    }

    private int read4(char[] buf) {
        return 0;
    }
}

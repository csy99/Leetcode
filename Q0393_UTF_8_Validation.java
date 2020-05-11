package Leetcode;

/**
 * Created by csy99 on 4/17/20.
 */
public class Q393_UTF_8_Validation {
    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int val = data[i];
            int numByte = 0;
            if (val > 255)
                return false;
            if ((val & 128) == 0)
                numByte = 1;
            else if ((val & 224) == 192)
                numByte = 2;
            else if ((val & 240) == 224)
                numByte = 3;
            else if ((val & 248) == 240)
                numByte = 4;
            else
                return false;
            for (int j = 1; j < numByte; j++) {
                if (i + j >= data.length)
                    return false;
                if ((data[i + j] & 192) != 128)
                    return false;
            }
            i += numByte - 1;
        }
        return true;
    }
}

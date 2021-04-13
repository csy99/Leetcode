package Leetcode;

/**
 * Created by csy99 on 4/12/21.
 */
public class Q520_Detect_Capital {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0)
            return true;

        int upperCaseCount = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c))
                upperCaseCount++;
        }
        if (upperCaseCount == 0 || upperCaseCount == word.length())
            return true;
        if (upperCaseCount == 1 && Character.isUpperCase(word.charAt(0)))
            return true;
        return false;
    }
    
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        boolean all_cap = true;
        boolean first_cap = true;
        boolean all_lower = true;
        boolean rest_lower = true;
        char[] arr = word.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (Character.isLowerCase(c))  {
                all_cap = false;
                if (i == 0) {
                    first_cap = false;
                }
            } else {
                all_lower = false;
                if (i > 0)
                    rest_lower = false;
            }
            if (!all_cap && !(first_cap && rest_lower) && ! all_lower)
                return false;
        }
        return true;
    }
}

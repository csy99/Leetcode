/**
 * Created by csy99 on 10/10/21.
 */
class Solution {
    public String reformat(String s) {
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c))
                digits.append(c);
            else
                letters.append(c);
        }
        if (Math.abs(digits.length() - letters.length()) > 1)
            return "";
        StringBuilder sb = new StringBuilder();
        int n = Math.min(digits.length(), letters.length());
        for (int i = 0; i < n; i++)
            sb.append(digits.charAt(i)).append(letters.charAt(i));
        if (digits.length() > letters.length())
            sb.append(digits.charAt(digits.length()-1));
        else if (letters.length() > digits.length())
            sb.insert(0, letters.charAt(letters.length()-1));
        return sb.toString();
    }
}

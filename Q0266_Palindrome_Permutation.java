
/**
 * Created by csy99 on 3/21/20.
 * <p>
 * Given a string, determine if a permutation of the string could form a palindrome.
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 */

public class Q266_Palindrome_Permutation {
  public boolean canPermutePalindrome(String s) {
    if (s == null || s.length() == 0) return true;
    int[] freq = new int[128];
    for (char c: s.toCharArray()) 
      freq[c]++;
    int odd = 0;
    for (int i = 0; i < 128; i++) {
      if (freq[i] % 2 == 1) {
        if (++odd > 1)
          return false;
      }
    }
    return true;
  }
}

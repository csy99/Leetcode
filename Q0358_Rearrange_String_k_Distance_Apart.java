package Leetcode;

/**
 * Given a non-empty string str and an integer k, 
 * rearrange the string such that the same characters are at least distance k from each other.
 * All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
 *
 * str = "aabbcc", k = 3, Result: "abcabc". The same letters are at least distance 3 from each other.
 * Created by csy99 on 3/18/20.
 */
public class Q358_Rearrange_String_k_Distance_Apart {
  public String rearrangeString(String s, int k) {
    if (k < 2 || s.length() < 2) return s;
    int[] map = new int[26];
    for (char c: s.toCharArray()) 
      map[c-'a']++;
    StringBuilder sb = new StringBuilder();
    // order by frequency from large to small, breaking tie using lexi order
    PriorityQueue<int[]> pq = new PriorityQueue<>(
      (a,b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
    for (int i = 0; i < 26; i++) {
      if (map[i] > 0)
        pq.add(new int[]{i, map[i]});
    }
    while (!pq.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < k; i++) {
        int[] cur = pq.coll();
        sb.append((char) (cur[0] + 'a'));
        list.add(cur[0]);
        if (pq.size() == 0) {
          if (i != k - 1 && sb.length() != s.length())
            return "";
          break;
        }
      }
      for (int i: list) {
        if (--map[i] > 0)
          pq.add(new int[] {i, map[i]});
      }
    }
    return sb.toString();
  }
}

package Leetcode;

/**
 * Created by csy99 on 3/19/20.
 */
public class Q273_Integer_to_English_Words {
  private final String[] UNIT = {"", "Thousand", "Million", "Billion"};
  private final String[] SMALL = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  
  private void helper(StringBuilder sb, int num) {
    if (num == 0) return;
    if (num < 20) 
      sb.append(SMALL[num]).append(" ");
    else if (num < 100) {
      sb.append(TENS[num/10]).append(" ");
      helper(sb, num % 10);
    }
    else {
      sb.append(SMALL[num/100]).append(" Hundred ");
      helper(sb, num % 100);
    }
  }
  
  public String numberToWords(int num) {
    if (num == 0) return "Zero";
    StringBuilder sb = new StringBuilder();
    int idx = 0;
    while (num > 0) {
      if (num % 1000 > 0) {  // extract last three number
        StringBuilder tmp = new StringBuilder();
        helper(tmp, num % 1000);
        sb.insert(0, tmp.append(UNIT[idx]).append(" "));
      }
      idx++;
      num /= 1000;
    }
    return sb.toString().trim();
  }
}

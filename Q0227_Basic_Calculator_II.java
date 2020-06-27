package Leetcode;

import java.util.Stack;

/**
 * Created by csy99 on 3/24/20.
 */
public class Q227_Basic_Calculator_II {
  public int calculate(String s) {
    String[] arr = tokenize(s);
    Deque<Integer> operand = new LinkedList();
    Deque<String> operator = new LinkedList();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].equals("*")) {
        operand.offerLast(operand.pollLast() * Integer.parseInt(arr[i+1]));
        i++;
      } else if (arr[i].equals("/")) {
        operand.offerLast(operand.pollLast() / Integer.parseInt(arr[i+1]));
        i++;
      } else if (arr[i].equals("+") || arr[i].equals("-")) {
        operator.offerLast(arr[i]);
      } else {  // number
        operand.offerLast(Integer.parseInt(arr[i]));
      }
    }
    
    while (!operator.isEmpty()) {
      int first = operand.pollFirst();
      int second = operand.pollFirst();
      String op = operator.pollFirst();
      if (op.equals("+"))
        operand.push(first+second);
      else
        operand.push(first-second);
    }
    return operand.pollFirst();
  }
  
  private String[] tokenize(String s) {
    s = s.trim();
    ArrayList<String> res = new ArrayList();
    int i = 0;
    while (i < s.length()) {
      char c = s.charAt(i);
      if (c == ' ')
        i++;
      else if (c == '*' || c == '/' || c == '+' || c == '-') {
        res.add(String.valueOf(c));
        i++;
      } else {  // number
        int start = i;
        while (i < s.length() && Character.isDigit(s.charAt(i)))
          i++;
        res.add(s.substring(start, i));
      }
    }
    String[] ret = new String[res.size()];
    ret = res.toArray(ret);
    return ret;
  }

    // stack, time: O(n)
    public int calculate(String s) {
        Stack<Integer> nums = new Stack();
        s = s.trim();
        char[] arr = s.toCharArray();
        char sign = '+';
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                int num = arr[i] - '0';
                while (i+1 < arr.length && Character.isDigit(arr[i+1])) 
                    num = num*10 + (arr[++i]-'0');
                if (sign == '+') 
                    nums.push(num);
                else if (sign == '-')
                    nums.push(-num);
                else if (sign == '*')
                    nums.push(nums.pop() * num);
                else if (sign == '/')
                    nums.push(nums.pop() / num);
            } else if (arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/') 
                sign = arr[i];
        }
        int res = 0;
        for (int num: nums)
            res += num;
        return res;
    }

    public static void main(String[] args) {
        Q227_Basic_Calculator_II sol = new Q227_Basic_Calculator_II();
        String s = "1*2-3/4+5*6-7*8+9/10";
        int result = sol.calculate(s);
        System.out.println(result);
    }
}

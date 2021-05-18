package Leetcode;

import java.util.Stack;

/**
 * Created by csy99 on 3/24/20.
 */
public class Q224_Basic_Calculator {
class Solution {
  public int calculate(String s) {
    String[] arr = tokenize(s);
    
    Stack<Integer> operand = new Stack();
    Stack<Pair> operator = new Stack();
    int level = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].isEmpty())
        continue;
      else if (arr[i].equals("("))
        level++;
      else if (arr[i].equals(")"))
        level--;
      else if (arr[i].equals("+") || arr[i].equals("-")) {
        Pair pair = new Pair(level, arr[i]);
        while (!operator.isEmpty() && level <= operator.peek().level) {
          int second = operand.pop();
          int first = operand.pop();
          String op = operator.pop().op;
          int remainder = op.equals("+") ? first+second: first-second;
          operand.push(remainder);
        }
        operator.push(pair);
      } else  // number
        operand.push(Integer.parseInt(arr[i]));
    }
    while (!operator.isEmpty()) {
      int second = operand.pop();
      int first = operand.pop();
      String op = operator.pop().op;
      int remainder = op.equals("+") ? first+second: first-second;
      operand.push(remainder);
    }
    return operand.pop();
  }
  
  private String[] tokenize(String s) {
    s = s.trim();
    ArrayList<String> res = new ArrayList();
    int i = 0;
    while (i < s.length()) {
      char c = s.charAt(i);
      if (c == ' ')
        i++;
      else if (c == '(' || c == ')' || c == '+' || c == '-') {
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
    // System.out.println(Arrays.toString(ret));
    return ret;
  }
}

class Pair {
  int level;
  String op;
  
  public Pair (int lv, String op) {
    level = lv;
    this.op = op;
  }
}
}

class Solution {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack();
        Stack<Character> ops = new Stack();
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        boolean prev_op = false;
        
        while (i < n) {
            if (arr[i] == ' ') {
                i++;
                continue;
            } else if (arr[i] >= '0' && arr[i] <= '9') {
                int num = 0;
                while (i < n && arr[i] >= '0' && arr[i] <= '9') {
                    num = num*10 + (arr[i]-'0');
                    i++;
                }
                nums.push(num);
                prev_op = false;
                i--;
            } else if (arr[i] == '(') {
                ops.push(arr[i]);
                prev_op = true;
            } else if (arr[i] == ')') {
                evaluate(nums, ops);
                prev_op = false;
            } else {
                // to address sth like 1+(-9+7)
                if (prev_op)  
                    nums.push(0);
                ops.push(arr[i]);
                prev_op = true;
            }
            i++;
        }
        evaluate(nums, ops);
        return nums.peek();
    }
    
    private void evaluate(Stack<Integer> nums, Stack<Character> ops) {
        int cur = 0;
        int num2 = 0;
        char op = '+';
        while (ops.size() > 0 && ops.peek() != '(') {
            op = ops.pop();
            num2 = nums.pop();
            if (op == '+')
                cur += num2;
            else
                cur -= num2;
        }
        if (nums.size() > 0)
            cur += nums.pop();
        if (ops.size() > 0 && ops.peek() == '(')
            ops.pop();
        nums.push(cur);
    }
}

/**
 * Created by csy99 on 8/26/20.
 * <p>
 * Write a program that outputs the string representation of numbers from 1 to n.
 * <p>
 * But for multiples of three it should output “Fizz” instead of the number
 * and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 */
public class Q412_Fizz_Buzz {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0)
                res.add("FizzBuzz");
            else if (i % 3 == 0)
                res.add("Fizz");
            else if (i % 5 == 0)
                res.add("Buzz");
            else
                res.add(String.valueOf(i));
        }
        return res;
    }
}

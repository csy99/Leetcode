/**
 * Created by csy99 on 8/20/20.
 */
public class Q528_Random_Pick_with_Weight {
    int[] sums;
    Random rand = new Random();
    
    public Solution(int[] w) {
        int n = w.length;
        sums = new int[n+1];
        for (int i = 0; i < n; i++)
            sums[i+1] = w[i] + sums[i];
    }
    
    public int pickIndex() {
        int n = sums.length;
        int total = sums[n-1];
        int prob = rand.nextInt(total);
        for (int i = 1; i <= n; i++) {
            if (prob < sums[i])
                return i-1;
        }
        return n-1;
    }
}


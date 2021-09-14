class Utils {
    Integer comb[max][max];
    
    static int combination(int n, int k) {
        if (k > n-k) return combination(n, n-k);
        if(r==0) return comb[n][r] = 1;
        if(r==1) return comb[n][r] = n;
        if(comb[n][r] != null) return comb[n][r]; 
        return comb[n][r] = combination(n-1,r) + combination(n-1,r-1);
    }
    
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
  
    static int lcm(int a, int b, int gcdValue) {
        return Math.abs(a * b) / gcdValue;
    } 
  
    static List<Integer> primeFactor(int num) {
        List<Integer> factors = new ArrayList();
        for (int i = 2; i <= num/i; i++) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }
        if (num > 1) 
            factors.add(num);
        return factors;
    }

}

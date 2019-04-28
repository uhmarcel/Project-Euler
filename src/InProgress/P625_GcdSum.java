package InProgress;

/* Problem No. 625 - Gcd sum */

public class P625_GcdSum {
    
    public static int getGcdSum(int n, int mod) {        
        for (int j=1; j<=n; j++) {
                    int sum = 0;
            for (int i=1; i<=j; i++) {
                int gcd = greatestCommonDivisor(i,j);
                sum += gcd;
                System.out.println("gcd("+i+","+j+") = "+gcd+ " -> "+sum);
                if (sum > mod) sum = sum % mod;
            }
            System.out.println("j="+j+" -> "+sum);
        }
        return 0;
    }
    
    public static int greatestCommonDivisor(int a, int b) {
        int limit = (a < b) ? a : b;
        
        for (int i=limit; i>0; i--) {
            if (a%i == 0 && b%i == 0) 
                 return i;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        final int MOD_RESULT = 998244353;
        final long PROBLEM_SIZE = 10000000L;
        
        long count = 0;
        for (int j=0; j<PROBLEM_SIZE; j++) {
            for (int i=0; i<j; i++) {
                count++;
            }
        }
        System.out.println("done");
    }

}

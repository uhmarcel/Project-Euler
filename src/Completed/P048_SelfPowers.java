package Completed;

/* Problem No. 48 - Self Powers */

public class P048_SelfPowers {
    
    public static final long PRECISION = (long) 1e10;
    
    public static long selfPow(long n) {
        long result = 1;
        
        for (int i=0; i<n; i++) {
            result = result * n;
            result = result % PRECISION;
        }
        return result;
    }
    
    public static long sumSelfPowers(int n) {
        long sum = 0;
        for (int i=1; i<=n; i++) {
            sum += selfPow(i);
            sum = sum % PRECISION;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        long result = sumSelfPowers(100000);
        System.out.println(result);
    }

}


package Completed;

/* Problem No. 30 - Digit Fifth Powers */

public class P030_DigitFifthPowers {
    
    public static long digitPowers(int n) {
        int limit = (int)Math.pow(10,n+1);
        int total = 0;
        
        for (int i=2; i<limit; i++) {    
            int sum = 0;
            for (int j=0; j<n+1; j++) {
                int currentDigit = getDigit(i, j);
                sum += (int) Math.pow(currentDigit, n);
            }
            if (sum == i) {
                total += i;
            }
        }
        
        return total;
    }
    
    public static int getDigit(long number, int n) {
        for (int i=0; i<n; i++)
            number = number/10;
        return (int) number%10;
    }
    
    public static void main(String[] args) {
        long result = digitPowers(5);
        System.out.println(result);
    }

}
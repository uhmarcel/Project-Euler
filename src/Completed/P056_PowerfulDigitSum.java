package Completed;

import java.math.BigInteger;

/* Problem No. 56 - Powerful digit sum */

public class P056_PowerfulDigitSum {
    
    public static final int APROX_MIN = 90;
    public static final int MAX = 100;
    
    public static int powDigitSum(int a, int b) {
        BigInteger A = BigInteger.valueOf(a).pow(b);
        BigInteger TEN = BigInteger.valueOf(10);
        int digitSum = 0;
        
        while (A != BigInteger.ZERO) {
            digitSum += A.mod(TEN).intValue();
            A = A.divide(TEN);
        }
        return digitSum;
    }
    
    public static void main(String[] args) {
        int largestSum = 0;
        int currentSum = 0;
        for (int j=APROX_MIN; j<MAX; j++) {
            for (int i=APROX_MIN; i<MAX; i++) {
                currentSum = powDigitSum(i,j);
                System.out.print("digitSum(" +i+ "^" +j+ ") = " + currentSum);
                if (currentSum > largestSum) {
                    largestSum = currentSum;
                    System.out.print("  ->  new largest");
                }
                System.out.println();
            }
        }
        System.out.println("Largest digit sum found = " + largestSum);
    }

}

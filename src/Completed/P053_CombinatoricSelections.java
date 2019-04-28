package Completed;

import java.math.BigInteger;

/* Problem No. 53 - Combinatoric selections */

public class P053_CombinatoricSelections {
    
    public static final int LIMIT = 100;
    public static final int TARGET = 1000000;
    public static BigInteger[] dynamicFactorial; 
    
    public static void initFactorialMap(int upTo) {
        dynamicFactorial = new BigInteger[upTo + 1];
        dynamicFactorial[0] = BigInteger.ONE; 
        BigInteger current = BigInteger.ONE;
        
        for (int i=1; i<=upTo; i++) {
            current = current.multiply(BigInteger.valueOf(i));
            dynamicFactorial[i] = current;
        }
    }
    
    public static BigInteger fact(int n) {
        if (n<0 || n>= dynamicFactorial.length) {
            return null;
        }
        return dynamicFactorial[n];
    }
    
    public static BigInteger getCombinations(int n, int r) {
        return fact(n).divide(fact(r)).divide(fact(n-r));
    }
    
    public static void main(String[] args) {
        initFactorialMap(LIMIT);
        int overTarget = 0;
        
        for (int n=1; n<=LIMIT; n++) {
            for (int r=1; r<=n; r++) {
                BigInteger result = getCombinations(n, r);
                System.out.print("C("+ n +", "+ r +") = "+ result);
                
                if (result.compareTo(BigInteger.valueOf(TARGET)) > 0) {
                    overTarget++;
                    System.out.print("  ->  over target (" + TARGET + ")");
                }
                System.out.println();
            }
        }
        System.out.println(overTarget + " combinations are over " + TARGET);
    }

}

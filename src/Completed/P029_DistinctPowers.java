package Completed;


import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/* Problem No. 29 - Distinct powers */

public class P029_DistinctPowers {
    
    public static long distinctPowers(int size) {
        Set<BigInteger> powers = new HashSet<>();
        
        for (int a=2; a<=size; a++) {
            for (int b=2; b<=size; b++) {
                BigInteger result = BigInteger.valueOf(a).pow(b);
                powers.add(result);
            }
        }
        return powers.size();
    }
    
    public static void main(String[] args) {
        long result = distinctPowers(10000);
        System.out.println(result);
    }
}

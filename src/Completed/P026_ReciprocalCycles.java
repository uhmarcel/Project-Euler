package Completed;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/* Problem No. 26 - Reciprocal cycles */

public class P026_ReciprocalCycles {  

/* Based upon repeating decimal mathematical approach.
 * https://en.wikipedia.org/wiki/Repeating_decimal
 */    
    public static boolean isPrimitiveRoot(int a, int p) {
        Set<Integer> found = new HashSet<>();
        BigInteger A = BigInteger.valueOf(a);
        for (int i=1; i<p; i++) {
            int current = (A.modPow(BigInteger.valueOf(i), BigInteger.valueOf(p))).intValueExact();
            if (found.contains(current))
                return false;
            found.add(current);
        }
        return true;
    }
    
    public static int[] getPrimesUpTo(int n) {
        boolean[] list = new boolean[n];
        for (int i=2; i<n; i++)
            list[i] = true;      
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (list[i]) {
                for (int j=0; j<n; j++) {
                    int s = i*i+j*i;
                    if (s>=n)
                        break;
                    list[s] = false;
                }
            }
        }
        int j = 0;
        for (int i=0; i<n; i++) {
            if (list[i])
                j++;
        }
        int[] output = new int[j];
        j=0;
        for (int i=0; i<n; i++) {
            if (list[i]) {
                output[j] = i;
                j++;
            }
        }
        return output;        
    } 
    
    public static void main(String[] args) {
        final int PROBLEM_SIZE = 1000;
        int[] primes = getPrimesUpTo(PROBLEM_SIZE);
        
        for (int p : primes) {
            if (p < 7) 
                continue;
            if (isPrimitiveRoot(10, p))
                System.out.println("Found 1/"+p+" with repeating cycle "+(p-1));
        }
        
    }
    
}

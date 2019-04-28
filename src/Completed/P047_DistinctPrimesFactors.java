package Completed;

import java.util.ArrayList;
import java.util.List;

/* Problem No. 47 - Distinct primes factors */

public class P047_DistinctPrimesFactors {
    
    // Note: This solution is not optimized, has innecesary re-calculations.
    // Current solve time: 4 seconds.
    // Adding a set to hold prime factors would fix the issue.
    
    public static boolean hasDistinctPrimeFactors(int[] primes, int n) {
        List<Integer> A = getPrimeFactors(primes, n);
        if (A.size() != 4) return false;
        
        List<Integer> B = getPrimeFactors(primes, n+1);
        if (B.size() != 4) return false;
        
        List<Integer> C = getPrimeFactors(primes, n+2);
        if (C.size() != 4) return false;
        
        List<Integer> D = getPrimeFactors(primes, n+3);
        if (D.size() != 4) return false;
        
        for (int a : A) {
            if (B.contains(a) || C.contains(a) || D.contains(a))
                return false;
        }
        return true;
    }
    
    public static List<Integer> getPrimeFactors(int[] primes, int n) {
        List<Integer> factors = new ArrayList<>();
        
        for (int p=0; primes[p] <= n; p++) {
            if (n % primes[p] == 0) {
                int a = primes[p];
                int b = a;
                while (n % (b * a) == 0 && (b * a) <= n) {
                    b = b * a;
                }
                factors.add(b);
            }
        }
        return factors;
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
        final int MAX = 1000000;
        int primes[] = getPrimesUpTo(MAX*2);
        
        for (int i=1; i<MAX; i++) {
            if (hasDistinctPrimeFactors(primes, i)) {
                System.out.println("Found " + i);
                System.out.println(i + " -> " + getPrimeFactors(primes, i));
                System.out.println(i+1 + " -> " + getPrimeFactors(primes, i+1));
                System.out.println(i+2 + " -> " + getPrimeFactors(primes, i+2));
                System.out.println(i+3 + " -> " + getPrimeFactors(primes, i+3));
                return;
            }
        }
    }
    
}

package Completed;

import java.util.ArrayList;
import java.util.List;

/* Problem No. 49 - Prime permutations */

public class P049_PrimePermutations {
    
    public static boolean isPermutation(int a, int b) {
        List<Integer> A = toDigitList(a);
        List<Integer> B = toDigitList(b);
        A.sort(null);
        B.sort(null);
        
        if (A.size() != B.size())
            return false;
        
        for (int i=0; i<A.size(); i++) {
            if (A.get(i) != B.get(i))
                return false;
        }
        return true;
    }
    
    public static List<Integer> toDigitList(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n != 0) {
            digits.add(n % 10);
            n = n / 10;
        }
        return digits;
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
    
    public static boolean isPrime(long n) {
        if (n<0)  return false;
                
        for (int i=2; i<n; i++) {
            if (n%i == 0)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[] primes = getPrimesUpTo(10000);
        
        for (int i=0; i<primes.length; i++) {
            int a, b, c;
            a = primes[i];
            b = a + 3330;
            if (isPermutation(a, b) && isPrime(b)) {
                c = b + 3330;
                if (isPermutation(a, c) && isPrime(c)) {
                    System.out.println("Found " + a);
                    System.out.println("Made of "+a+", "+b+", "+c);
                }
            }
        }
    }
}

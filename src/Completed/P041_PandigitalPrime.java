package Completed;

import java.util.HashSet;
import java.util.Set;

/* Problem No. 41 - Pandigital prime */

public class P041_PandigitalPrime {
    
    public static final int MAX = 100000000;
    
    public static boolean isPandigital(int n) {
        Set<Integer> digits = new HashSet<>();
        int copy = n;
        int size = 0;
        
        while (copy > 0) {
            digits.add(copy % 10);
            copy = copy / 10;
            size++;
        }
        if (size != digits.size()) 
            return false;
        
        for (int i=1; i<=size; i++) {
            if (!digits.contains(i))
                return false;
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
        int[] primes = getPrimesUpTo(MAX);
        
        for (int current : primes) {
            if (isPandigital(current))
                System.out.println("Found " + current);
        }
    }
    
}

package Completed;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* Problem No. 32 - Pandigital products */

public class P032_PandigitalProducts {
    
    public static boolean isPandigitalProduct(int a, int b, int c) {
        boolean[] availableDigits = new boolean[10];
        Arrays.fill(availableDigits, true);
        availableDigits[0] = false;

        if (!checkDigits(availableDigits, a)) return false;
        if (!checkDigits(availableDigits, b)) return false;
        if (!checkDigits(availableDigits, c)) return false;
        
        for (int i=0; i<10; i++) {
            if (availableDigits[i] == true)
                return false;
        }
        return true;
    }
    
    private static boolean checkDigits(boolean[] available, int n) {
        while (n != 0) {
            int digit = n % 10;
            if (available[digit] == false)
                return false;
            available[digit] = false;
            n = n / 10; 
        }
        return true;
    }
    
    public static void main(String[] args) {
        final int MAX_SIZE = 10000;
        Set<Integer> found = new HashSet<>();
        
        for (int a=1; a<MAX_SIZE; a++) {
            for (int b=1; b<MAX_SIZE; b++) {
                int c = a * b;
                if (isPandigitalProduct(a,b,c) && !found.contains(c)) {
                    System.out.println("Found "+a+" x "+b+" = "+c);
                    found.add(c);
                }
            }
        }
        
        int sum = 0;
        for (int element : found) 
            sum += element;
        System.out.println("Final result " + sum);
        
    }

}

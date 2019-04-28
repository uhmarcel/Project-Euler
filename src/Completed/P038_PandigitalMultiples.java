package Completed;

import java.util.Arrays;

/* Problem No. 38 - Pandigital multiples */

public class P038_PandigitalMultiples {
    
    public static final int NOT_FOUND = -1;
    
    public static int getPandigitalFactor(int n) {
        boolean[] digits = new boolean[10];
        Arrays.fill(digits, true);
        digits[0] = false;
        long concatenated = 0;
        long factor = n;
        
        checkDigits(digits, factor);
        concatenated = factor;
        while (!isDone(digits)) {
            factor = factor + n;
            if (!checkDigits(digits, factor))
                return NOT_FOUND;
            long copy = factor;
            while (copy != 0) {
                concatenated *= 10;
                copy = copy / 10;
            }
            concatenated += factor;
        }     
        for (int i=0; i<10; i++) {
            if (digits[i] == true)
                return NOT_FOUND;
        }
        return (int)concatenated;
    }
    
    private static boolean isDone(boolean[] available) {
        for (int i=0; i<10; i++) {
            if (available[i] == true)
                return false;
        }
        return true;        
    }
    
    private static boolean checkDigits(boolean[] available, long n) {
        while (n != 0) {
            int digit = (int) n % 10;
            if (digit == 0) return false;
            if (available[digit] == false)
                return false;
            available[digit] = false;
            n = n / 10; 
        }
        return true;
    }
    
    public static void main(String[] args) {
        int largest = 0;
        for (int i=1; i<100000; i++) {
            int current = getPandigitalFactor(i);
            if (current > largest) {
                System.out.println("Found new largest chain "+current+" at i="+i);
                largest = current;
            }
        }
        System.out.println("Largest chain: " + largest);
    }

}

package Completed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Problem No. 43 - Sub-string divisibility */

public class P043_SubstringDivisibility {
    
    public static boolean isPandigitalNumber(long n) {
        if (n==0) return false;
        boolean[] digits = new boolean[10];
        Arrays.fill(digits, true);
        
        while(n!=0) {
            int digit = (int)(n % 10);
            if (!digits[digit])
                return false;
            digits[digit] = false;
            n = n / 10;
        }
        return true;
    }
    
    public static int getSize(long n) {
        int count = 0;
        while (n!=0) {
            n = n/10;
            count++;
        }
        return count;
    }

    
    public static void main(String[] args) {
        final int DIVISIBLE_BY[] = {17, 13, 11, 7, 5, 3, 2, 1};
        
        List<Long> result = new ArrayList<>(); 
        int currentLength = 0;
        
        for (int i=0; i<1000; i+=DIVISIBLE_BY[0]) {
            if (isPandigitalNumber(i))
                result.add((long)i);
        }
        
        currentLength = 3;
        for (int div = 1; div<DIVISIBLE_BY.length; div++) {
            int size = result.size();
            for (int i=0; i<size; i++) {
                long current = result.remove(0);
                for (int d=0; d<10; d++) {
                    long n = current + (long) (d * Math.pow(10,currentLength));
                    int lastThree = (int)(n / (long) (Math.pow(10, currentLength-2)));
                    if (lastThree % DIVISIBLE_BY[div] == 0 && isPandigitalNumber(n)) {
                        result.add(n);
                    }
                }
            }
            currentLength++;   
        }
        
        int size = result.size();
        for (int i=size-1; i>=0; i--) {
            if (getSize(result.get(i)) != currentLength)
                result.remove(i);
        }
        System.out.println("Result set: " + result);
        
        long sum = 0;
        for (long e : result) 
            sum += e;
        System.out.println("Sum: " + sum);
    }

}

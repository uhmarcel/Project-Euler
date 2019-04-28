package Completed;

import java.util.ArrayList;
import java.util.List;

/* Problem No. 23 - Non-Abundant Numbers */

public class P023_NonAbundantNumbers {
    
    public static final int UPPER_LIMIT = 10000;
    
    public static List<Integer> getAbundantNumbers() {
        List<Integer> abundantNumbers = new ArrayList<>();
        
        for (int i=2; i<=UPPER_LIMIT; i++) {
            if (getSumProperDivisors(i) > i)
                abundantNumbers.add(i);
        }
        return abundantNumbers;
    }
    
    public static int getSumProperDivisors(int n) {
        int sum = 1;
        int sqrt = (int)Math.sqrt(n);
        for (int i=2; i<=sqrt; i++) {
            if (n%i == 0) {
                if (i == n/i)
                    sum += i;
                else {
                    sum += i;
                    sum += n/i;
                }
            }
        }
        return sum;
    }
    
    public static boolean isNonAbundantNumber(List<Integer> abunNrs, int n) {
        if (n > UPPER_LIMIT)  return false;
        
        for (int a=0; abunNrs.get(a)<n; a++) {
            for (int b=0; abunNrs.get(b)<n; b++) {
                if (abunNrs.get(a) + abunNrs.get(b) == n) {
                    return false;
                    
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        List<Integer> abundantNumbers = getAbundantNumbers();
        
        long sum = 0;
        for (int i=0; i<UPPER_LIMIT; i++) {
            if (isNonAbundantNumber(abundantNumbers, i))
                sum += i;
        }
        System.out.println(sum);
    }

}

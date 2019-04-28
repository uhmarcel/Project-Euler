package Completed;

import java.util.HashMap;
import java.util.Map;

/* Problem No. 52 - Permuted multiples */

public class P052_PermutedMultiples {
    
    public static final int EQUAL_MULTIPLES = 6;
    
    public static boolean hasMultipleSameDigits(long n, int multiple) {
        Map<Integer,Integer> A = new HashMap<>();            
        Map<Integer,Integer> B = new HashMap<>();      
        insertDigits(A, n);
        
        for (int i=1; i<=multiple; i++) {
            B.clear();
            insertDigits(B, n*i);
            if (A.equals(B) == false)
                return false;
        }
        return true;        
    }
    
    public static void insertDigits(Map<Integer,Integer> map, long d) {
        while (d != 0) {
            int currentDigit = (int) (d % 10);
            d = d / 10;
            if (map.containsKey(currentDigit))
                map.put(currentDigit, map.get(currentDigit) + 1);
            else
                map.put(currentDigit, 1);
        }
    }
    
    public static void main(String[] args) {
        for (int i=1; i<Integer.MAX_VALUE; i++) {
            if (hasMultipleSameDigits(i, EQUAL_MULTIPLES)) {
                System.out.println("Found " + i);
                break;
            }
        }
    }

}

package Completed;

import java.util.ArrayList;
import java.util.List;

/* Problem No. 33 - Digit cancelling fractions */

public class P033_DigitCancellingFractions {

    // Ugliest method I've ever wrote...
    public static boolean isCancellableFraction(int num, int denom) {
        if (num == denom || num >= denom)  return false;
        
        boolean[] digitPos = new boolean[2];
        int unitA = num % 10;
        int unitB = denom % 10;
        int tensA = num / 10;
        int tensB = denom / 10;
        
        if (unitA == 0 || unitB == 0)
            return false;
        
        if (unitA == unitB) { digitPos[0] = true; digitPos[1] = true; }
        else if (unitA == tensB) { digitPos[0] = true; digitPos[1] = false; }
        else if (tensA == unitB) { digitPos[0] = false; digitPos[1] = true; }
        else if (tensA == tensB) { digitPos[0] = false; digitPos[1] = false; }
        else { return false; }
        
        int newNum, newDenom;
        if (!digitPos[0])  newNum = unitA;
        else  newNum = tensA;
        if (!digitPos[1])  newDenom = unitB;
        else  newDenom = tensB;
        
        return (num/(double)denom) == (newNum/(double)newDenom);
    }

    public static List getDivisors(long n) {
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=Math.sqrt(n); i++) {
            if (n%i == 0) {
                if (i == n/i)
                    list.add(i);
                else {
                    list.add(i);
                    list.add((int)n/i);
                }
            }
        }
        list.sort(null);
        return list;
    }
        
    public static int simplify(int[] fraction) {
        List<Integer> divA = getDivisors(fraction[0]);
        List<Integer> divB = getDivisors(fraction[1]);
        
        int greatestFactor = 0;
        for (int a : divA) {
            for (int b : divB) {
                if (a == b && a > greatestFactor)
                    greatestFactor = a;
            }
        }
        fraction[0] = fraction[0] / greatestFactor;
        fraction[1] = fraction[1] / greatestFactor;
        return greatestFactor;
    }
    
    
    public static void main(String[] args) {
        final int MAX = 100;
        final int MIN = 10;
        
        int[] result = {1, 1};
        
        for (int a=MIN; a<MAX; a++) {
            for (int b=MIN; b<MAX; b++) {
                if (isCancellableFraction(a,b)) {
                    System.out.println("Found "+ a +"/"+ b);
                    result[0] *= a;
                    result[1] *= b;
                }
            }
        }     
        
        System.out.println("Product: "+result[0]+"/"+result[1]);
        simplify(result);
        System.out.println("Simplified: "+result[0]+"/"+result[1]);
        
    }
    
}

package Completed;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* Problem No. 40 - Champernowne's constant */

public class P040_ChampernownesConstant {
    
    public static final int SIZE = 1000000;
    
    public static List<Byte> champernowneDigitsUpTo(int n) {
        List<Byte> digits = new ArrayList<>();
        digits.add((byte)0);
        Stack<Byte> buffer = new Stack<>();
        int counter = 1;
        while (digits.size() <= n) {
            int current = counter;
            while (current > 0) {
                buffer.push((byte)(current%10));
                current = current / 10;                
            }
            
            while (!buffer.isEmpty()) {
                digits.add(buffer.pop());
            }
            counter++;
        }
        return digits;
    }
    
    public static void main(String[] args) {
        List<Byte> d = champernowneDigitsUpTo(SIZE);
        long result = 1;
        
        result *= d.get(1);
        result *= d.get(10);
        result *= d.get(100);
        result *= d.get(1000);
        result *= d.get(10000);
        result *= d.get(100000);
        result *= d.get(1000000);
        
        System.out.println(result);
    }

}

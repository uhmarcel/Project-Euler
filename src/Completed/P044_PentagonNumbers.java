package Completed;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Problem No. 44 - Pentagon numbers */

public class P044_PentagonNumbers {
    
    public static Set<Long> getPentagonalNumbers() {
        Set<Long> pentagons = new HashSet<>();
        long current = 0;
        long n = 1;
        while (current < Integer.MAX_VALUE) {
            current = n*(3*n-1)/2;
            pentagons.add(current);
            n++;
        }
        return pentagons;
    } 
    
    public static void main(String[] args) {
        Set<Long> pentaHash = getPentagonalNumbers();
        List<Long> pentaSorted = new ArrayList<>();
        pentaSorted.addAll(pentaHash);
        pentaSorted.sort(null);
        
        long smallestDifference = Long.MAX_VALUE;
        int size = pentaSorted.size();
        
        for (int j=0; j<size; j++) {
            for (int i=0; i<j; i++) {
                if (j+i >= size) break;
                long A, B, dif;
                A = pentaSorted.get(i);
                B = pentaSorted.get(j);
                dif = B-A;
                if (pentaHash.contains(dif) &&
                    pentaHash.contains(A+B)) {
                    if (dif < smallestDifference) {
                        smallestDifference = dif;
                        System.out.println("Found pair " + A + " and " + B);
                    }
                }
            }
        }
        System.out.println("Best result = " + smallestDifference);
    }

}

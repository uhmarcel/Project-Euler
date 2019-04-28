package Completed;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* Problem No. 39 - Integer right triangles */

public class P039_IntegerRightTriangles {
    
    public static List<Integer[]> getPythagoreanTriplesUpTo(int n) {
        List<Integer[]> triples = new ArrayList<>();
        
        for (int a=1; a<n; a++) {
            for(int b=a; b<n; b++) {
                double cFloat = Math.sqrt(a*a + b*b);
                int c = (int) cFloat;
                if (c == cFloat) {
                    Integer[] found = new Integer[3];
                    found[0] = a;
                    found[1] = b;
                    found[2] = c;
                    triples.add(found);
                }
            }
        }
        return triples;
    }
    
    public static void main(String[] args) {
        List<Integer[]> triples = getPythagoreanTriplesUpTo(500);
        Map<Integer,Integer> perimetersCount = new TreeMap<>();
        int bestPerimeter = 0;
        int concurrent = 0;
        for (Integer[] e : triples) {
            int perimeter = e[0] + e[1] + e[2];
            int currentCount = 0;
            if (perimetersCount.containsKey(perimeter)) {
                currentCount = perimetersCount.get(perimeter);
                if (currentCount > concurrent) {
                    bestPerimeter = perimeter;
                    concurrent = currentCount + 1;
                }
            }
            perimetersCount.put(perimeter, currentCount + 1);
        }
        
        System.out.println("Best perimeter "+bestPerimeter+" with "+concurrent+
                           " solutions");
    }
}

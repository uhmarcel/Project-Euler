package Completed;

import java.util.HashSet;
import java.util.Set;

/* Problem No. 45 - Triangular, pentagonal, and hexagonal */

public class P045_TriangularPentagonalHexagonal {
    
    public static Set<Long> getTriangleNumbers() {
        Set<Long> triangles = new HashSet<>();
        long current = 0;
        long n = 1;
        while (current < Integer.MAX_VALUE) {
            current = n*(n+1)/2;
            triangles.add(current);
            n++;
        }
        return triangles;
    } 

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
        
    public static Set<Long> getHexagonalNumbers() {
        Set<Long> hexagons = new HashSet<>();
        long current = 0;
        long n = 1;
        while (current < Integer.MAX_VALUE) {
            current = n*(2*n-1);
            hexagons.add(current);
            n++;
        }
        return hexagons;
    } 
    
    public static void main(String[] args) {
        Set<Long> t = getTriangleNumbers();
        Set<Long> p = getPentagonalNumbers();
        Set<Long> h = getHexagonalNumbers();
        
        for (long x : h) {
            if (p.contains(x) && t.contains(x))
                System.out.println("Found " + x);
        }    
    }
    
}

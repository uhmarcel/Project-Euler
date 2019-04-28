package Completed;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/* Problem No. 50 - Consecutive prime sum */

public class P050_ConsecutivePrimeSum {

    public static Set<Integer> getPrimesUpTo(int n) {
        Set<Integer> primes = new LinkedHashSet<>();
        boolean[] list = new boolean[n];
        for (int i=2; i<n; i++)
            list[i] = true;      
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (list[i]) {
                for (int j=0; j<n; j++) {
                    int s = i*i+j*i;
                    if (s>=n)
                        break;
                    list[s] = false;
                }
            }
        }
        for (int i=0; i<n; i++) {
            if (list[i]) {
                primes.add(i);
            }
        }
        return primes;        
    } 
    
    public static void main(String[] args) {
        final int LIMIT = 1000000;
        
        Map<Integer,Integer> consecutiveSum = new TreeMap<>();
        Set<Integer> primes = getPrimesUpTo(LIMIT);
        Integer[] p = primes.toArray(new Integer[0]);
        
        for(int i=0; i<primes.size(); i++) {
            int concurrent = 0;
            int sum = 0;
            for (int j=i; j<primes.size(); j++) {
                if (sum >= LIMIT) break;
                sum += p[j];
                concurrent++;
                if (primes.contains(sum)) {
                    if (consecutiveSum.containsKey(sum)) {
                        if (concurrent > consecutiveSum.get(sum))
                            consecutiveSum.put(sum, concurrent);
                    }
                    else {
                        consecutiveSum.put(sum, concurrent);
                    }
                }
            }
        }
        
        int bestPrime = 0;
        int consecutives = 0;
        for (Entry<Integer,Integer> e : consecutiveSum.entrySet()) {
            if (e.getValue() > consecutives) {
                bestPrime = e.getKey();
                consecutives = e.getValue();
                System.out.println("Found " + bestPrime + " with " + 
                                   consecutives + " consecutive primes");
            }
        }
        System.out.println("Result = " + bestPrime);        
    }
}

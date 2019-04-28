package Completed;

/* Problem No. 27 - Quadratic Primes */

public class P027_QuadraticPrimes {
    
    public static final int LIMIT = 1000;
    
    public static int quadraticPrimes(int a, int b) {
        boolean prime = true;
        int consecutives = 0;
        int n = 0;
        
        while (prime) {
            long current = (n*n) + (a*n) + b;
            if (isPrime(current))
                consecutives++;
            else
                prime = false;
            n++;
        }
        return consecutives;
    }
    
    public static boolean isPrime(long n) {
        if (n<0)  return false;
                
        for (int i=2; i<n; i++) {
            if (n%i == 0)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int bestConsecutives = 0;
        int bestProduct = 0;
        
        for (int a = LIMIT-1; a>LIMIT*(-1); a--) {
            for (int b = LIMIT*(-1)+1 ; b<LIMIT; b++) {
                int consecutives = quadraticPrimes(a, b);
                if (consecutives > bestConsecutives) {
                    bestConsecutives = consecutives;
                    bestProduct = a * b;
                    System.out.println("Best consecutive primes = " + 
                            consecutives + ". \tFrom n^2 +("+ a +")n + "+ b);
                }
            }
        }
        
        System.out.println(bestProduct);
    }

}

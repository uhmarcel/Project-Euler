package Completed;

/* Problem No. 46 - Goldbach's other conjecture */

public class P046_GoldbachsOtherConjecture {

    public static boolean hasGoldbachsConjecture(int[] primes, long n) {
        if (n % 2 == 0 || binarySearch(primes, (int)n) != -1) 
            return false;
        
        for (int p=1; primes[p]<n; p++) {
            for (int i=1; i*i<n; i++) {
                long conjecture = primes[p] + 2*(i*i);
                if (conjecture > n)
                    break;
                if (conjecture == n)
                    return true;
            }
        }
        return false;
    }
    
    public static int binarySearch(int[] array, int key) {
        return binarySearchRecursive(array, 0, array.length-1, key);
    }
    
    private static int binarySearchRecursive(int[] array, int bottom, int top, int key) {        
        while (top >= bottom) {
            int middle = (top + bottom) / 2;   
            if (array[middle] == key) {
                return middle;
            }
            else if (array[middle] < key) {
                bottom = middle + 1;
            }
            else {
                top = middle - 1;
            }
        }
        return -1;
    } 
    
    public static int[] getPrimesUpTo(int n) {
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
        int j = 0;
        for (int i=0; i<n; i++) {
            if (list[i])
                j++;
        }
        int[] output = new int[j];
        j=0;
        for (int i=0; i<n; i++) {
            if (list[i]) {
                output[j] = i;
                j++;
            }
        }
        return output;        
    } 
    
    public static void main(String[] args) {
        final int MAX = 1000000;
        int primes[] = getPrimesUpTo(MAX);
        
        for (int i=3; i<MAX; i+= 2) {
            if (i % 2 == 0 || binarySearch(primes, (int)i) != -1)
                continue;
            if (!hasGoldbachsConjecture(primes, i)) {
                System.out.println("Found " + i);
                return;
            }
            
        }
    }
           
}

package Completed;

/* Problem No. 37 - Truncatable primes */

public class P037_TruncatablePrimes {
    
    public static boolean isTruncatablePrime(int[] primes, int index) {
        if (primes[index] < 10)  return false;
        
        int n = primes[index];
        while (n != 0) {
            if (!binarySearch(primes, n))
                return false;
            n = truncateLeftToRight(n);
        }
        n = primes[index]; 
        while (n != 0) {
            if (!binarySearch(primes, n))
                return false;
            n = truncateRightToLeft(n);
        }
        return true;
    }
    
    public static int truncateLeftToRight(int n) {
        int exponent = 1;
        int copy = n;
        
        while (copy != 0) {
            copy = copy / 10;
            exponent *= 10;
        }
        return n % (exponent/10);
    }
    
    public static int truncateRightToLeft(int n) {
        return n / 10;
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
    
    public static boolean binarySearch(int[] array, int element) {        
        int bottom = 0;
        int top = array.length - 1;
        
        while (top >= bottom) {
            int middle = (top + bottom) / 2;   
            if (array[middle] == element) {
                return true;
            }
            else if (array[middle] < element) {
                bottom = middle + 1;
            }
            else {
                top = middle - 1;
            }
        }
        return false;
    } 
    
    public static int getSize(int n) {
        int count = 0;
        while (n!=0) {
            n = n/10;
            count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        int[] primes = getPrimesUpTo(10000000);
        long sum = 0;
        
        for (int i=0; i<primes.length; i++) {
            if (isTruncatablePrime(primes, i)) {
                System.out.println(primes[i] +" found");
                sum += primes[i];
            }
        }
        
        System.out.println("Total sum = " + sum);       
    }

}

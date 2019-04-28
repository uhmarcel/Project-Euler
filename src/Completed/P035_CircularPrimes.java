package Completed;

/* Problem No. 35 - Quadratic Primes */

public class P035_CircularPrimes {
    
    public static final int UPPER_LIMIT = 1000000;
    
    public static boolean isCircularPrime(int[] primes, int index) {
        int current = rotateDigits(primes[index]);
        while (current != primes[index]) {
            if (!binarySearch(primes, current))
                return false;
            current = rotateDigits(current);
        } 
        System.out.println("Found circular prime " + primes[index]);
        return true;
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
    
    public static int rotateDigits(int input) {
        int firstDigit = input % 10;
        int size = 0;
        
        input = input / 10;
        size = getSize(input);
        input += firstDigit * Math.pow(10, size);
        return input;
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
        int[] primes = getPrimesUpTo(UPPER_LIMIT);
        int circularPrimes = 0;
        
        for (int i=0; i<primes.length; i++) {
            if (isCircularPrime(primes, i)) 
                circularPrimes++;
        }
        System.out.println(circularPrimes);
    }
    
}

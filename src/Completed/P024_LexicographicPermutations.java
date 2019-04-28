package Completed;


/* Problem No. 24 - Lexicographic Permutations */

public class P024_LexicographicPermutations {

    public static int[] nextPermutation(int[] p) {
        int base = 0;
        int smallest = 0;
        
        for (int i=0; i < p.length - 1; i++) {
            if (p[i] < p[i+1])
                base = i;
        }
        for (int i=base+1; i < p.length; i++) {
            if (p[base] < p[i])
                smallest = i;
        }
        p = swap(p, base, smallest);
        p = reverse(p, base);
        return p;
    }
    
    public static int[] swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        return array;
    }
    
    public static int[] reverse(int[] array, int from) {
        int[] out = new int[array.length];
        
        for (int i=0; i <= from; i++)
            out[i] = array[i];
        
        int j = from+1;
        for (int i = array.length-1; i > from; i--) {
            out[j] = array[i];
            j++;
        }
        return out;
    }
    
    public static void printArray(int[] array) {
        for (int i=0; i<array.length; i++) 
            System.out.print(array[i]);
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] p = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        for (int j=1; j<1000000; j++) {
            p = nextPermutation(p);
        }
        printArray(p);
    }
    

}




/*
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation 
of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, 
we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
*/
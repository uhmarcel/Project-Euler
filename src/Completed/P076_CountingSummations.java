package Completed;

/* Problem No. 76 - Counting summations */

public class P076_CountingSummations {
    
    public static int possibleCombinations(int[] set, int value) {
        return combinationsRecursive(set, value, 0);
    }
    
    private static int combinationsRecursive(int[] set, int value, int setIndex) {
        if (setIndex == set.length - 1) return 1;
                
        int combinations = combinationsRecursive(set, value, setIndex + 1);
        int currentCoin = set[setIndex];
       
        while(currentCoin <= value) {
            value = value - currentCoin;
            combinations += combinationsRecursive(set, value, setIndex + 1);
        }
        return combinations;        
    }
    
    public static int[] getDecreasingArray(int n) {
        int[] array = new int[n];
        for (int i=0; i<n; i++) {
            array[i] = n - i;
        }
        return array;
    }
    
    public static void main(String[] args) {
        final int PROBLEM_SIZE = 6;
        int[] set = getDecreasingArray(PROBLEM_SIZE);
        
        int combinations = possibleCombinations(set, PROBLEM_SIZE);
        System.out.println("Sum of two combinations = " + (combinations-1));
    }

}

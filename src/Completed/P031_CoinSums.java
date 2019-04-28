package Completed;

/* Problem No. 31 - Coin sums */

public class P031_CoinSums {
    
    public static final int[] coins = {200, 100, 50, 20, 10, 5, 2, 1};
    
    public static int possibleCombinations(int value) {
        return combinationsRecursive(value, 0);
    }
    
    private static int combinationsRecursive(int value, int coinIndex) {
        if (coinIndex == coins.length - 1) return 1;
                
        int combinations = combinationsRecursive(value, coinIndex + 1);
        int currentCoin = coins[coinIndex];
       
        while(currentCoin <= value) {
            value = value - currentCoin;
            combinations += combinationsRecursive(value, coinIndex + 1);
        }
        return combinations;        
    }
    
    public static void main(String[] args) {
        System.out.println(possibleCombinations(20));
    }
    
}

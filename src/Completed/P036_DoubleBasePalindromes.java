package Completed;


/* Problem No. 36 - Double-base Palindromes */

public class P036_DoubleBasePalindromes {

    public static boolean isPalindrome(int n) {
        return isPalindrome(Integer.toString(n));
    }
    
    public static boolean isPalindrome(String n) {
        if (n.length() <= 1)
            return true;
        
        if (n.charAt(0) == n.charAt(n.length()-1)) 
            return isPalindrome(n.substring(1, n.length()-1));
        return false;
    }
    
    public static String toBinary(int n) {
        if (n == 0)  return "";
        
        if (n%2 == 1) 
            return toBinary(n/2) + "1";
        else
            return toBinary(n/2) + "0";
    }
    
    
    public static void main(String[] args) {
        int sumDoublePalindromes = 0;
        for (int i=1; i<1000000; i++) {
            if (isPalindrome(i)) {
                if (isPalindrome(toBinary(i)))
                    sumDoublePalindromes += i;
            }
        }
        System.out.println(sumDoublePalindromes);        
    }
}

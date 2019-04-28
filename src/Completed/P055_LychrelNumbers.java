package Completed;

/* Problem No. 55 - Lychrel numbers */

public class P055_LychrelNumbers {
    
    public static final int MAX_ITERATIONS = 30;
    public static final int TEST_UPTO = 10000;
    
    public static long reverse(long n) throws Exception {
        if (n < 0)
            throw new Exception();
        long out = 0;
        while (n != 0) {
            out = out*10 + n%10;
            n = n / 10;
        }
        return out;
    }
    
    public static boolean isPalindrome(String s) {
        if (s.length() < 2)
            return true;
        return s.charAt(0)==s.charAt(s.length()-1) && 
                isPalindrome(s.substring(1, s.length()-1));
    }

    
    public static boolean isLychrelNumber(long n) throws Exception {
        long r;
        for (int i=0; i<MAX_ITERATIONS; i++) {
            r = reverse(n);
            n = n + r;
            if (isPalindrome(String.valueOf(n)))
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        int found = 0;
        for (int i=0; i<TEST_UPTO; i++) {
            if (isLychrelNumber(i)) {
                System.out.println("Found " + i);
                found++;
            }
        }
        System.out.println("Total of "+ found +" Lychrel numbers below " + 
                           TEST_UPTO);
    }
    
}

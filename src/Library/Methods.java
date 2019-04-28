package Library;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Methods {
    
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
    
    public static long reverse(long n) {
        long out = 0;
        while (n != 0) {
            out = out*10 + n%10;
            n = n / 10;
        }
        return out;
    }
    
    public static Map<Character,Integer> getCharFrequency(String input) {
        Map<Character,Integer> ocurrance = new HashMap<>();
        
        for (int i=0; i<input.length(); i++) {
            char current = input.charAt(i);
            if (ocurrance.containsKey(current)) 
                ocurrance.put(current, ocurrance.get(current) + 1);
            else
                ocurrance.put(current, 1);    
        }
        return ocurrance;
    }
    
    public static void printArray(int[] array) {
        for (int i=0; i<array.length; i++) 
            System.out.print(array[i]);
        System.out.println();
    }
    
    public static boolean isPrimitiveRoot(int a, int p) {
        Set<Integer> found = new HashSet<>();
        BigInteger A = BigInteger.valueOf(a);
        for (int i=1; i<p; i++) {
            int current = (A.modPow(BigInteger.valueOf(i), BigInteger.valueOf(p))).intValueExact();
            if (found.contains(current))
                return false;
            found.add(current);
        }
        return true;
    }
    
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
    
    public static List<Integer> permuteAll(int input) {
        List<Integer> permutations = new ArrayList<>();
        int size = getIntegerSize(input);
        
        permuteAllRecursive(permutations, input, size);
        return permutations;
    }
        
    private static int permuteAllRecursive(List<Integer> list, int input, int size) { 
        if (size == 1) 
             list.add(input);
  
        for (int i=0; i<size; i++) { 
            input = permuteAllRecursive(list, input, size-1); 
            if (size % 2 == 1) 
                input = swapDigits(input, 0, size-1);
            else 
                input = swapDigits(input, i, size-1);
        } 
        return input;
    } 
    
    public static int getIntegerSize(int n) {
        int count = 0;
        while (n!=0) {
            n = n/10;
            count++;
        }
        return count;
    }
    
    public static int swapDigits(int number, int a, int b) {
        int first = (number / (int)Math.pow(10,a)) % 10;
        int second = (number / (int)Math.pow(10,b)) % 10;
        number += (second-first) * (int)Math.pow(10,a);
        number += (first-second) * (int)Math.pow(10,b);
        return number;            
    }
    
    public static int getDigit(long number, int n) {
        for (int i=0; i<n; i++)
            number = number/10;
        return (int) number%10;
    }
    
    public static long collatz(long n) {
        if (n%2 == 0)
            return n/2;
        else
            return 3*n + 1;
    }
    
    public static int greatestCommonDivisor(int a, int b) {
        int limit = (a < b) ? a : b;
        
        for (int i=limit; i>0; i--) {
            if (a%i == 0 && b%i == 0) 
                 return i;
        }
        return 0;
    }
    
    public static List getDivisors(long n) {
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=Math.sqrt(n); i++) {
            if (n%i == 0) {
                if (i == n/i)
                    list.add(i);
                else {
                    list.add(i);
                    list.add((int)n/i);
                }
            }
        }
        list.sort(null);
        return list;
    }
    
    public static int[] getProperDivisors(long n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (n%i == 0) {
                if (i == n/i)
                    list.add(i);
                else {
                    list.add(i);
                    list.add((int)n/i);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static int getDivisorsAmount(long n) {
        int counter = 0;
        for (int i=1; i<=Math.sqrt(n); i++) {
            if (n%i == 0) {
                if (i==n/i)
                    counter++;
                else
                    counter += 2;
            }
        }
        return counter;
    }
    
    public static boolean isPalindrome(String s) {
        if (s.length() < 2)
            return true;
        return s.charAt(0)==s.charAt(s.length()-1) && isPalindrome(s.substring(1, s.length()-1));
    }
    
    public static boolean isPrime(long n) {
        for (int i=2; i<n; i++) {
            if (n%i == 0)
                return false;
        }
        return true;
    }
    
    public static long getNthPrime(int n) {
        long counter = 1;
        while (n!=0) {
        counter++;
            if (isPrime(counter))
                n--;
        }
        return counter;
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
     
    public static String generateWord(long n) {
        
        if (n == 0)
            return "zero";
        Map<Integer, String> words = new HashMap<>();
        words.put(1, "one");
        words.put(2, "two");
        words.put(3, "three");
        words.put(4, "four");
        words.put(5, "five");
        words.put(6, "six");
        words.put(7, "seven");
        words.put(8, "eight");
        words.put(9, "nine");
        words.put(10, "ten");        
        words.put(11, "eleven");
        words.put(12, "twelve");
        words.put(13, "thirteen");
        words.put(14, "fourteen");
        words.put(15, "fifteen");
        words.put(16, "sixteen");
        words.put(17, "seventeen");
        words.put(18, "eighteen");
        words.put(19, "nineteen");       
        words.put(20, "twenty");
        words.put(30, "thirty");
        words.put(40, "forty");
        words.put(50, "fifty");
        words.put(60, "sixty");
        words.put(70, "seventy");
        words.put(80, "eighty");
        words.put(90, "ninety");
        
        String out = new String();        
        
        for (int i=5; i>=0; i--) {
       
            long value = (n/((long)Math.pow(10, 3*i)));
            int h = (int) (value % 1000);
            int t = h % 100;
            int u = t % 10;

            if (h/100 != 0) {
                out += words.get(h/100) + " ";
                out += "hundred ";
                if (value%100 != 0)
                    out += "and ";
            }
            if (t/10 > 1) {
                out += words.get((t/10) * 10);
                if (u != 0)
                    out += "-";
                else
                    out += " ";
            }
            else 
                u = t % 20;
            if (u != 0){
                if (!(u==10 && t/10!=1))
                    out += words.get(u) + " ";
            }
            if (h!=0) {
                switch (i) {
                    case 1: out += "thousand "; break;
                    case 2: out += "million "; break;
                    case 3: out += "billion "; break;
                    case 4: out += "trillion "; break;
                    case 5: out += "quadrillion "; break;
                }
            }
        }
        if (out.charAt(out.length()-1) == ' ')
            out = out.substring(0, out.length()-1);
        return out;       
    }
    
    public static int problem67(int[][] tree) {
        for (int y=tree.length-1; y>=0; y--) {
            for (int x=0; x<y; x++) {
                if (tree[y][x] > tree[y][x+1])
                    tree[y-1][x] += tree[y][x];
                else
                    tree[y-1][x] += tree[y][x+1];
            }
        }
        return tree[0][0];
    }
    
    public static long factorial(long n) {
        if (n==0) return 1;
        long result = 1;
        for (int i=1; i<=n; i++)
            result *= i;
        return result;
    }
    
    
}

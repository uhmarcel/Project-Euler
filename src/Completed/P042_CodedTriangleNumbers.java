package Completed;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/* Problem No. 42 - Coded triangle numbers */

public class P042_CodedTriangleNumbers {
    
    public static final String INPUT_FILENAME = "src/Input/input_p042.txt";
    public static final int MAX = 1000;
    
    public static Set<Integer> getTriangleNumbersUpTo(int n) {
        Set<Integer> triangles = new HashSet<>();
        int counter = 1;
        int last = 0;
        
        while (last < n) {
            last = counter * (counter+1) / 2;
            triangles.add(last);
            counter++;
        }
        return triangles;
    }
    
    public static boolean isTriangleWord(Set<Integer> triangles, String word) {
        return triangles.contains(sumStringCharacters(word));
    }
    
    public static int sumStringCharacters(String word) {
        int sum = 0;
        for (int i=0; i<word.length(); i++) {
            sum += getCharValue(word.charAt(i));
        }
        return sum;
    }
    
    public static int getCharValue(char c) {
        return c - 'A' + 1;
    }
   
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File(INPUT_FILENAME));
        s.useDelimiter(",");
        
        Set<Integer> triangleSet = getTriangleNumbersUpTo(MAX);
        int triangleWords = 0;
        
        while (s.hasNext()) {
            String current = s.next().replaceAll("\"","");
            if (isTriangleWord(triangleSet, current))
                triangleWords++;
        }
        System.out.println(triangleWords);
        s.close();
    }

}

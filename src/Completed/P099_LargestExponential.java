package Completed;

import java.io.File;
import java.util.Scanner;

/* Problem No. 99 - Largest exponential */

public class P099_LargestExponential {
    
    public static final String INPUT_FILENAME = "src/Input/input_p099.txt";

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File(INPUT_FILENAME));
        double largestFound = 0;
        double currentResult = 0;
        int largestLine = 0;
        int currentLine = 1;
        int A, B;
        
        while (s.hasNextLine()) {
            String[] input = s.nextLine().split(",");
            A = Integer.parseInt(input[0]);
            B = Integer.parseInt(input[1]);
            currentResult = B * Math.log(A);
            System.out.printf("Line %3d: %6d ^ %6d", currentLine, A, B);
            
            if (currentResult > largestFound) {
                largestFound = currentResult;
                largestLine = currentLine;
                System.out.print(" -> Current largest");
            }    
            System.out.println();
            currentLine++;       
        }
        System.out.println("Largest number at line " + largestLine);
        s.close();
    }
    
}
